package ajplarson.flooringmastery.controller;

import ajplarson.flooringmastery.models.Order;
import ajplarson.flooringmastery.models.Product;
import ajplarson.flooringmastery.models.State;
import ajplarson.flooringmastery.service.OrderService;
import ajplarson.flooringmastery.service.Result;
import ajplarson.flooringmastery.ui.MainMenuOption;
import ajplarson.flooringmastery.ui.View;
import java.time.LocalDate;
import java.util.List;

public class TheBrains {

    private final View view;
    private final OrderService service;

    public TheBrains(View view, OrderService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        view.printStarLine();
        view.welcome();

        MainMenuOption selection;

        do {
            selection = view.selectFromMainMenu();
            switch (selection) {
                case DISPLAY_ORDERS:
                    displayOrders();
                    break;
                case ADD_ORDER:
                    addOrder();
                    break;
                case EDIT_ORDER:
                    editOrder();
                    break;
                case REMOVE_ORDER:
                    removeOrder();
                    break;
            }
        } while (selection != MainMenuOption.QUIT);
        view.printStarLine();
        view.goodbye();
    }

    private void displayOrders() {
        List<Order> orders = service.findByDate(view.readDate("Please enter a date to view orders"));
        if (orders == null) {
            view.displayOrdersNotFoundForDate();
        } else {
            view.displayOrders(orders);
            view.hitEnterToContinue();
        }
    }

    private void addOrder() {
        view.displayCreateBanner();
        List<State> states = service.getStates();
        List<Product> products = service.getProducts();
        LocalDate date = view.readDate("Please enter the date you would like the flooring to be installed");
        Order order = view.getOrderInformation(date, states, products);
        Result<Order> result = service.checkOrder(order, date); //check to make sure valid info
        if (result.hasError()) {
            view.displayErrors(result);
        } else {
            //confirm whether or not the customer wants the order
            if (view.confirmOrder(result.getValue())) {
                order.setDate(date);
                service.add(order, date);
                view.displayCreateSuccessBanner();
            }
        }
    }

    //test this and ensure that order numbers are being set to the same
    private void editOrder() {
        view.displayEditBanner();
        LocalDate date = view.readDate("Please enter the date of the order that you would like to edit");
        if (service.findByDate(date) == null) {
            view.displayOrdersNotFoundForDate();
        } else {
            view.displayOrders(service.findByDate(date));
            int orderNumber = view.getOrderNumber("Please enter the order number of the order that you would like to edit");
            if (service.checkOrderNumber(orderNumber, date).hasError()) {
                view.displayErrors(service.checkOrderNumber(orderNumber, date));
            } else {
                Order orderToEdit = service.getOrder(orderNumber, date); //store old information for the enter skipping
                Order editedOrder = new Order(); //the order we will return
                editedOrder = view.getEditInfo(orderToEdit, date); //get new info using the old order as our default

                //for specific error handling
                String stateName = editedOrder.getState().getStateName();
                editedOrder.setState(service.getRestOfState(stateName)); //completes the rest of our state

                String productName = editedOrder.getProduct().getMaterialType();
                editedOrder.setProduct(service.getRestOfProduct(productName));

                Result<Order> result = service.edit(editedOrder, date);
                if (result.hasError()) {
                    view.displayErrors(result);
                } else {
                    if (view.confirmOrder(result.getValue())) {
                        view.displayEditOrderSuccessBanner();
                    }
                }
            }
        }

    }

    private void removeOrder() {
        view.displayRemoveBanner();
        LocalDate date = view.readDate("Please enter the date of the order that you would like to remove");
        view.displayOrders(service.findByDate(date));
        int orderNumber = view.getOrderNumber("Please enter the order number of the order that you would like to remove");
        Order orderToRemove = service.getOrder(orderNumber, date);
        if (orderToRemove.getDate() == null) {
            orderToRemove.setDate(date);
        }
        if (view.confirmRemoveOrder(orderToRemove)) {
            service.remove(orderToRemove, date);
            view.displayRemoveSuccessBanner();
        }

    }
}

package ajplarson.flooringmastery.ui;

import ajplarson.flooringmastery.models.Cost;
import ajplarson.flooringmastery.models.Order;
import ajplarson.flooringmastery.models.Product;
import ajplarson.flooringmastery.models.State;
import ajplarson.flooringmastery.service.Response;
import ajplarson.flooringmastery.service.Result;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class View {

    private final ConsoleIO io;

    public View(ConsoleIO io) {
        this.io = io;
    }

    //from Corbin March's lottery program
    public MainMenuOption selectFromMainMenu() {
        int min = 1;
        int max = 5;
        for (MainMenuOption mmo : MainMenuOption.values()) {
            io.print(String.format("%s. %s", mmo.getValue(), mmo.getName()));
            min = Math.min(mmo.getValue(), min);
            max = Math.max(mmo.getValue(), max);
        }
        int value = io.readInt(String.format("Select [%s-%s]:", min, max), min, max);
        return MainMenuOption.fromValue(value);
    }

    //BEGIN: general helpers
    public boolean confirm(String message) {
        return io.readBoolean(String.format("%s [y/n]:", message));
    }

    private void printHeader(String message) {
        io.print(String.format("  %s  ", message));
    }

    public void welcome() {
        printHeader("AAA Flooring!");
    }

    public void printStarLine() {
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
    }

    public void printUnderScoreLine() {
        io.print("___________________________________");
    }

    public void goodbye() {
        printHeader("Good Bye!");
    }

    //method idea from Vincent
    public LocalDate readDate(String prompt) throws DateTimeParseException {
        while (true) {
            try {
                io.print(prompt);
                String year = io.readRequiredString("Please enter a year (e.g. 2018)");
                String month = io.readRequiredString("Please enter a month (e.g. 02)");
                String day = io.readRequiredString("Please enter a day (e.g. 07)");
                return LocalDate.parse(year + "-" + month + "-" + day);

            } catch (DateTimeParseException e) {
                io.print("Please enter valid date information");
            }
        }
    }

    //formats big decimals
    public static String bigDecimalFormat(BigDecimal number) {
        return number.setScale(2, RoundingMode.HALF_UP).toPlainString();
    }

    public void hitEnterToContinue() {
        io.readString("Please hit enter to continue");
    }

    //END: general helpers
    //BEGIN: display
    public void displayProductTypes(List<Product> products) {
        io.print("We currently support the following materials for our high quality flooring: ");
        for (Product product : products) {
            io.print(String.format("Material: %s Material Cost per sq. ft: %s [$/sf] Labor Cost per sq. ft: %s [$/sf]",
                    product.getMaterialType(),
                    bigDecimalFormat(product.getMaterialCostPerSquareFoot()),
                    bigDecimalFormat(product.getLaborCostPerSquareFoot())));
        }
    }

    public void displayStates(List<State> states) {
        io.print("We currently install flooring in the following states: ");
        for (State state : states) {
            io.print(String.format("State: %s Tax Rate: %s percent", state.getStateName(), bigDecimalFormat(state.getTaxRate())));
        }
    }

    void displayOrder(Order o) {
        if (o != null) {
            printUnderScoreLine();
            io.print(String.format("Order Number: %d", o.getOrderNumber()));
            io.print(o.getCompany());
            io.print(String.format("Type of flooring: %s",
                    o.getProduct().getMaterialType()));
            io.print(String.format("Area (in sq. ft): %s",
                    bigDecimalFormat(o.getArea())));
            io.print(String.format("Cost per sq. ft: %s [$/sf] Labor Cost per sq. ft: %s [$/sf]",
                    bigDecimalFormat(o.getProduct().getMaterialCostPerSquareFoot()),
                    bigDecimalFormat(o.getProduct().getLaborCostPerSquareFoot())));
            io.print(String.format("State: %s Tax rate: %s percent",
                    o.getState().getStateName().toUpperCase(),
                    bigDecimalFormat(o.getState().getTaxRate())));
            displayCost(o);
            printUnderScoreLine();
        } else {
            io.print("That order does not exist");
        }
        io.readString("Please press enter to continue");

    }

    public void displayOrderConcise(Order o) {
        if (o != null) {
            printUnderScoreLine();
            io.print(String.format("Order Number: %d", o.getOrderNumber()));
            io.print(o.getCompany());
            if (o.getDate() != null) {
                io.print(String.format("Date: %s", o.getDate()));
            }
            printUnderScoreLine();
        } else {
            io.print("That order does not exist");
        }
        io.readString("Please press enter to continue");
    }

    public void displayCost(Order o) {
        printHeader("===Total Costs===");
        io.print(String.format("Material Cost: $%s Labor Cost: $%s",
                bigDecimalFormat(o.getCost().getMaterialCost()),
                bigDecimalFormat(o.getCost().getLaborCost())));
        io.print(String.format("Tax: $%s Gross Amount: $%s",
                bigDecimalFormat(o.getCost().getTax()),
                bigDecimalFormat(o.getCost().getGross())));
    }

    void displayOrdersBanner() {
        printHeader("=== ALL ORDERS FOR SPECIFIED DATE===");
    }

    public void displayOrdersNotFoundForDate() {
        io.print("No orders were found for that date.");
    }

//    
//    public void displayProductNotFound(String materialType) {
//        printHeader("ERROR");
//        io.print("No material matching " + " was found");
//    }
    public void displayOrders(List<Order> orders) {
        displayOrdersBanner();
        io.print("Please hit enter to cycle through orders");
        for (Order o : orders) {
            displayOrderConcise(o);
        }
    }

    public void displayErrors(Result r) {
        io.print("");
        printHeader("ERROR");
        for (String message : r.getErrors()) {
            io.print(message);
        }
        io.print("");
    }
    //END: display

    //BEGIN: CRUD
    //BEGIN: create
    public void displayCreateBanner() {
        io.print("===== Create an Order =====");
    }

    public Order getOrderInformation(LocalDate date, List<State> states, List<Product> products) {
        Order result = new Order();
        Product product = new Product();
        State state = new State();

        result.setDate(date);

        printHeader("Order Information");
        result.setCompany(io.readRequiredString("What is the name of your company?"));
        displayStates(states);
        state.setStateName(io.readRequiredString("Please enter the State of the order: (e.g. MN for Minnesota)"));
        result.setState(state);
        displayProductTypes(products);
        product.setMaterialType(io.readRequiredString("What type of flooring would you like?"));
        result.setProduct(product);
        result.setArea(io.readBigDecimal("What is the area of the proposed floor?"));
        return result;
    }

    public boolean confirmOrder(Order order) {
        if (order != null) {
            displayOrder(order);
            if (confirm("Would you like to enter this order?")) {
                return true;
            } else {
                io.readString("Order cancelled. Please hit enter to continue");
                return false;
            }
        } else {
            io.readString("Whoops. Press enter to try again");
            return false;
        }
    }

    public boolean confirmRemoveOrder(Order order) {
        displayOrder(order);
        if (confirm("Would you like to remove this order?")) {
            return true;
        } else {
            io.readString("Order removal cancelled. Please hit enter to continue");
            return false;
        }
    }

    public void displayCreateSuccessBanner() {
        io.readString("Order Successfully added. Please hit enter to continue");
    }
    //END: create

    //BEGIN: edit
    public void displayEditBanner() {
        io.print("===== Edit an Order =====");
    }

    public int getOrderNumber(String prompt) {
        return io.readInt(prompt);
    }

    public Order getEditInfo(Order order, LocalDate date) {
        displayOrder(order);
        State state = new State();
        Product product = new Product();
        Order editedOrder = new Order();
        editedOrder.setDate(date);
        editedOrder.setOrderNumber(order.getOrderNumber());
        //get all required info and validate
        String company = io.readString("Please enter the new desired company or press enter to skip changing this item");
        String stateName = io.readString("Please enter the new desired state name or press enter to skip changing this item");
        String productType = io.readString("Please enter the new desired flooring material or press enter to skip changing this item");
        String area = io.readString("Please enter the new desired area or press enter to skip changing this item");

        //set all required info
        if (company.isBlank()) { //if the title is not blank set it otherwise keep the same I had trim but it was not working with it
            editedOrder.setCompany(order.getCompany());
        } else {
            editedOrder.setCompany(company);
        }
        //same logic for all other cases
        if (stateName.isBlank()) {
            editedOrder.setState(order.getState());
        } else {
            try {
            state.setStateName(stateName);
            editedOrder.setState(state);
            } catch (Exception e) {
                io.print("Error: Invalid Input");
            }
        }
        if (productType.isBlank()) {
            editedOrder.setProduct(order.getProduct());
        } else {
            product.setMaterialType(productType);
            editedOrder.setProduct(product);
        }
        if (area.isBlank()) {
            editedOrder.setArea(order.getArea());
        } else {
            try {
                BigDecimal bigDecimalArea = new BigDecimal(area);
                editedOrder.setArea(bigDecimalArea);
            } catch (NumberFormatException ex) {
                io.print("Please enter a valid number");
            }
        }
        return editedOrder;
    }

    public void displayEditOrderSuccessBanner() {
        io.print("Order was successfully edited");
    }
    //END: edit

    //BEGIN: remove
    public void displayRemoveBanner() {
        io.print("===== Remove an Order =====");
    }

    //use get order number from edit method
    public void displayRemoveSuccessBanner() {
        io.readString("Order succesfully removed. Please hit enter to continue");
    }
    //END: remove

    //END: CRUD
}

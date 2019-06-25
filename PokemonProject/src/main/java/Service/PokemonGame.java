/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author ajplarson
 */
public class PokemonGame {

    public class VendingMachine {

        private ItemDAO dao;
      

        public VendingMachine(ItemDAO dao) {
            this.dao = dao;
        }

        public void addMoney(BigDecimal input) {
            wallet = (wallet.add(input));
        }

        public Item purchaseItem(int selection) throws InsufficientFundsException,
                OutOfStockException, ItemPersistenceException {
            Item item = dao.getAllItems().get(selection);
            Validation validation = new Validation();
            boolean hasErrors = false;
            do {
                if (validation.hasFunds(wallet, item)) {
                    if (validation.inStock(item)) {
                        wallet = wallet.subtract(item.getPrice());
                        item = dao.purchaseItem(selection);
                        hasErrors = false;
                        break;
                    } else {
                        throw new OutOfStockException("That Item is out of stock");
                    }
                } else {
                    throw new InsufficientFundsException("Out of funds");
                }
            } while (hasErrors = true);
            return item;
        }

        public List<Item> getAllItems() throws ItemPersistenceException {
            return dao.getAllItems();
        }

        public Item getItem(int selection) throws ItemPersistenceException {
            return dao.getItem(selection);
        }
    }

}

package com.spooky.market;

import company.market.task7.model.Cashier;
import company.market.task7.model.Check;
import company.market.task7.model.Item;
import company.market.task7.model.Market;
import company.market.task7.service.CheckService;

import java.util.Date;

public class MarketApp {
    public static void main(String[] args) {
        Item item1 = new Item();
        item1.setName("Hat");
        item1.setPrice(25);
        Item item2 = new Item("Chips",4.5);
        Check check = new Check();
        check.setDate(new Date());
        check.getItems().put(item1,2);
        check.getItems().put(item2,5);
        CheckService service = new CheckService();
        Cashier cashier1 = new Cashier();
        cashier1.setFirstName("Josh");
        cashier1.setLastName("Smith");
        Market market = new Market();
        market.setName("          Malwart");
        market.setRow(6);
        service.printCheck(market,cashier1,check,6);
        service.writeCheck(market,cashier1,check,6);
    }
}

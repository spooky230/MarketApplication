package com.spooky.market.service;

import company.market.task7.model.Cashier;
import company.market.task7.model.Check;
import company.market.task7.model.Item;
import company.market.task7.model.Market;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;

public class CheckService {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("y-MM-dd  hh-mm");

    public void printCheck(Market market, Cashier cashier, Check check, int row) {
        double cashAdder = 0;
        System.out.println(market.getName());
        System.out.println("Cashier: " + cashier.getFirstName() + " " + cashier.getLastName());
        System.out.println("Row: " + row);
        System.out.println(DATE_FORMAT.format(check.getDate()));
        System.out.println("Products: ");
        for (Map.Entry<Item, Integer> entry : check.getItems().entrySet()) {
            System.out.println(entry.getKey().getName() + ":       " + entry.getValue() + " x " + entry.getKey().getPrice() + " = " + (entry.getValue() * entry.getKey().getPrice()));
            cashAdder = cashAdder + (entry.getValue() * entry.getKey().getPrice());
        }
        System.out.println("______________________________________");
        System.out.println("Total: " + cashAdder);
    }

    public void writeCheck(Market market, Cashier cashier, Check check, int row) {
        String FILE = "check_" + DATE_FORMAT.format(check.getDate()) + ".txt";
        try {
            FileWriter writer =  new FileWriter(FILE);
            double cashAdder = 0;
            writer.write(market.getName() + System.lineSeparator());
            writer.write("Cashier: " + cashier.getFirstName() + " " + cashier.getLastName()+ System.lineSeparator());
            writer.write("Row: " + row+ System.lineSeparator());
            writer.write(DATE_FORMAT.format(check.getDate())+ System.lineSeparator());
            writer.write("Products: "+ System.lineSeparator());
            for (Map.Entry<Item, Integer> entry : check.getItems().entrySet()) {
                writer.write(entry.getKey().getName() + ":       " + entry.getValue() + " x " + entry.getKey().getPrice()
                        + " = " + (entry.getValue() * entry.getKey().getPrice()) + System.lineSeparator());
                cashAdder = cashAdder + (entry.getValue() * entry.getKey().getPrice());
            }
            writer.write("______________________________________" + System.lineSeparator());
            writer.write("Total: " + cashAdder + System.lineSeparator());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void PrintProducts(Check check){
       for(Item item1 : check.getItems().keySet()){
           System.out.println("name: " + item1.getName());
           System.out.println("price: " + item1.getPrice());
       }
    }
}

package com.spooky.market.model;

public class Cashier {
    private String firstName;
    private String lastName;
    public Cashier(){

    }
    public Cashier(String fName,String lName){
        firstName = fName;
        lastName = lName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

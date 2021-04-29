package com.spooky.market.model;

public class Market {
    private String name;
    private int row;
    public Market(){

    }
    public Market(String name,int row){
        this.name = name;
        this.row = row;
    }
    public String getName() {
        return name;
    }
    public int getRow() {
        return row;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setRow(int row) {
        this.row = row;
    }
}

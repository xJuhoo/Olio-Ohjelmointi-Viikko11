package com.example.groceriesapp;

import java.util.Comparator;

public class Item {
    private String name;
    private String notes;

    private int order;

    // Public constructor
    public Item(String name, String notes, int order){
        this.name = name;
        this.notes = notes;
        this.order = order;
    }

    // We need both getters and setters for name and notes because of the possibility to edit them
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getNotes(){
        return notes;
    }

    public void setNotes(String notes){
        this.notes = notes;
    }


    // For comparing the order of creating
    public static final Comparator<Item> sortOrders = new Comparator<Item>() {
        @Override
        public int compare(Item firstItem, Item secondItem) {
            return firstItem.order - (secondItem.order);
        }
    };

    // For comparing the names of the items
    public static final Comparator<Item> sortNames = new Comparator<Item>() {
        @Override
        public int compare(Item firstItem, Item secondItem) {
            return firstItem.name.compareTo(secondItem.name);
        }
    };








}
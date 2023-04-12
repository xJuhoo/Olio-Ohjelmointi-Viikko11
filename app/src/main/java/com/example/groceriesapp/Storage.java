package com.example.groceriesapp;

import java.util.ArrayList;

public class Storage {
    private ArrayList<Item> items = new ArrayList<>();
    private static Storage itemStorage = null;

    public Storage(){
    }

    // Singleton
    public static Storage getInstance(){
        if (itemStorage == null){
            itemStorage = new Storage();
        }
        return itemStorage;
    }

    // For adding items
    public void addItem(Item item){
        items.add(item);
    }

    // For deleting items
    public void deleteItem(String productName){
        int i = 0;

        for (Item item : items){
            if (item.getName().equals(productName)) {
                break;
            }
            i++;
        }
        items.remove(i);
    }

    // For listing items
    public ArrayList<Item> getItems() {
        return items;
    }

    // For getting specific item
    public Item getItem (int itemIndex){
        return items.get(itemIndex);
    }

}

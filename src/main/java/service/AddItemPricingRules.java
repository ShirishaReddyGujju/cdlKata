package service;

import model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddItemPricingRules {
    List<Item> items = new ArrayList<>();

    /**
     * This method used to add the available stock items and their pricing values
     * @return list of available items
     */
    public static List<Item> getItemPricing() {
        ArrayList<Item> items = new ArrayList<>();
        Item item1 = new Item("A", 50);
        Item item2 = new Item("B", 30);
        Item item3 = new Item("C", 20);
        Item item4 = new Item("D", 15);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);

        return items;
    }

    /**
     * Receives the new pricing rules from the command line
     * Adds the items to the pricing system
     */
    public static void addItemPricingRules() {


    }

}

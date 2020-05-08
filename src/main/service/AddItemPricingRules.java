package main.service;

import main.model.Item;

import java.util.ArrayList;
import java.util.List;

public class AddItemPricingRules {

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
}

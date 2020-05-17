package service;

import model.Item;

import java.util.ArrayList;
import java.util.List;

public class AddItemPricingRules {
    List<Item> items = new ArrayList<>();

    /**
     * This method used to add the available stock items and their pricing values
     * @return list of available items
     */
    public List<Item> getItemPricingList() {

        return items;
    }

    /**
     * Receives the new pricing rules from the command line
     * Adds the items to the pricing system
     */
    public void addItemPricingRules() {

    }

    public void addItemPricing(String itemName, double price){


    }


}

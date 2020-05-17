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
    public List<Item> getItemPricingList() {
        return items;
    }

    /**
     * Receives the new pricing rules from the command line
     * Adds the items to the pricing system
     */
    public void addItemPricingRules() {
        String itemName;
        double price;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please pass the new Item pricing details else type Exit");
        System.out.println("Please Enter Item Name");
        while(sc.hasNext()){
            itemName = sc.next();
            if (itemName.equalsIgnoreCase("exit")) {
                System.out.println("available Items: "+ getItemPricingList());
                return;
            }
            else {
                System.out.println("Please Enter Price of " + itemName);
                price = sc.nextDouble();
                addItemPricing(itemName, price);
                System.out.println("Please Enter Item Name or press Exit");
            }
        }

    }

    public void addItemPricing(String itemName, double price){
        Item item = new Item(itemName, price);
        items.add(item);
    }


}

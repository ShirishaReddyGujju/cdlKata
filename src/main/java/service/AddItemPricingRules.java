package service;

import model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddItemPricingRules {
    static List<Item> items = new ArrayList<>();

    /**
     *  @return list of available items
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
            Item availableItem = validateIfItemAlreadyExist(itemName);
            if (itemName.equalsIgnoreCase("exit")) {
                return;
            }
            else if(availableItem != null) {
                System.out.println("Item " + availableItem.getName()+ " with price " + availableItem.getPrice()+ " is already available");
                System.out.println("Please Enter New Item Name or press Exit");
            }
            else {
                System.out.println("Please Enter Price of " + itemName+ " in pence");
                price = sc.nextDouble();
                addItemPricing(itemName, price);
                System.out.println("Available Items are ");
                getItemPricingList().forEach(item -> System.out.println(item.getName() + " for "+ item.getPrice()));
                System.out.println("Please Enter New Item Name or press Exit");
            }
        }

    }

    public Item validateIfItemAlreadyExist(String inputItem) {
        Item availableItem = items.stream().filter(item -> item.getName().equalsIgnoreCase(inputItem)).findFirst().orElse(null);
        return availableItem;
    }

    public void addItemPricing(String itemName, double price){
        Item item = new Item(itemName, price);
        items.add(item);
    }


}

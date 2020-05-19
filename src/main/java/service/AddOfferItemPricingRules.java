package service;

import model.OfferItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddOfferItemPricingRules {

    static ArrayList<OfferItem> offerItems = new ArrayList<>();

    /**
     * This method used to add the offers available on items and their details
     * @return list of offer items
     */
    public List<OfferItem> getOfferItemRules() {
        return offerItems;
    }

    /**
     * Receives the new Offer pricing rules from the command line
     * Adds the offer  to the pricing system
     */
    public void addOfferItemPricingRules() {
        String itemName;
        int noOfItems;
        double price;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please pass the new Offer details else type Exit");
        System.out.println("Please Enter Item Name in Offer");
        while(sc.hasNext()) {
            itemName = sc.next();
            OfferItem availableItem = validateIfItemAlreadyExist(itemName);
            if (itemName.equalsIgnoreCase("exit")) {
               return;
            } else if (availableItem != null) {
                System.out.println(
                    availableItem.getGroup() + " Items of " + availableItem.getItemName() + " with price "
                    + availableItem.getPrice() + " is already available");
                System.out.println("Please Enter New Item Name or press Exit");
            } else {
                System.out.println("Please Enter No of " + itemName + " in offer");
                noOfItems = sc.nextInt();
                System.out.println("Please Enter Offer Price of " + noOfItems + " " + itemName + " in pence");
                price = sc.nextDouble();
                addOfferItemPricing(itemName, noOfItems, price);
                System.out.println("Available Items in Offer are ");
                getOfferItemRules().forEach(offerItem -> System.out
                    .println(offerItem.getGroup() + " " + offerItem.getItemName() + "'s for " + offerItem.getPrice()));
                System.out.println("Please Enter Item Name in Offer or press Exit");
            }
        }
    }

    public OfferItem validateIfItemAlreadyExist(String inputItem) {
        OfferItem availableItem = offerItems.stream().filter(item -> item.getItemName().equalsIgnoreCase(inputItem)).findFirst().orElse(null);
        return availableItem;
    }

    public void addOfferItemPricing(String name, int noOfItems, double price) {
        OfferItem offerItem = new OfferItem(name, noOfItems, price);
        offerItems.add(offerItem);
    }
}

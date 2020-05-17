package service;

import model.OfferItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddOfferItemPricingRules {

    ArrayList<OfferItem> offerItems = new ArrayList<>();

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

    }

    public void addOfferItemPricing(String name, int items, double price) {
    }
}

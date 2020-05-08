package main.service;

import main.model.OfferItem;

import java.util.ArrayList;
import java.util.List;

public class AddOfferItemPricingRules {

    /**
     * This method used to add the offers available on items and their details
     * @return list of offer items
     */
    public static List<OfferItem> getOfferItemRules() {
        ArrayList<OfferItem> offerItems = new ArrayList<>();
        OfferItem offerItem1 = new OfferItem("A", 3, 130);
        OfferItem offerItem2 = new OfferItem("B", 2, 45);
        offerItems.add(offerItem1);
        offerItems.add(offerItem2);
        return offerItems;
    }
}

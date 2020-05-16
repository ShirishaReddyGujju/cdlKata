package service.impl;

import model.Item;
import model.OfferItem;
import service.AddItemPricingRules;
import service.AddOfferItemPricingRules;
import service.CostGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CostGeneratorImpl implements CostGenerator {
    List<String> scannedItems = new ArrayList<>();

    private static List<Item> avaiableItems = AddItemPricingRules.getItemPricing();

    private static List<OfferItem> offerItems = AddOfferItemPricingRules.getOfferItemRules();

    private double totalCost = 0;

    /**
     * Accepts the scanned Item and calculates the total cost of the cart
     * @param item
     * @return total cost of the cart
     */
    @Override
    public double addItemAndGetTotalCost(String item) {
        scannedItems.add(item);
        Item product =
            avaiableItems.stream().filter(availableItem -> availableItem.getName().equalsIgnoreCase(item)).findFirst().get();

        OfferItem offerItem = getOfferedItem(product);
        return getTotalCost(product, offerItem);
    }

    /**
     * calculated the price to adjust if there are any offer Items else calculates the total cost.
     * @param scannedItem
     * @param offeritem
     * @return total cost of the cart
     */
    public double getTotalCost(Item scannedItem, OfferItem offeritem) {
        if (offeritem != null) {
            double priceToReduce = scannedItem.getPrice() * (offeritem.getGroup() - 1);
            scannedItems.removeIf(item -> item.equalsIgnoreCase(scannedItem.getName()));
            totalCost = (totalCost - priceToReduce) + offeritem.getPrice();
        }
        else {
            totalCost = totalCost + scannedItem.getPrice();
        }
        return totalCost;
    }

    /**
     * Searches for any offers that are available for the scanned Item
     * @param scannedItem
     * @return offerItem
     */
    public OfferItem getOfferedItem(Item scannedItem){
        String scannedItemName = scannedItem.getName();
        int group = Collections.frequency(scannedItems, scannedItemName);
        OfferItem item = offerItems.stream()
                                   .filter(offerItem ->
                                               (offerItem.getGroup() == group && offerItem.getItemName().equalsIgnoreCase(scannedItemName)))
                                   .findFirst()
                                   .orElse(null);

        return item;
    }

}


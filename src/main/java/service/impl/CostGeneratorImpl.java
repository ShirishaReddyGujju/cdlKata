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

    @Override
    public double addItemAndGetTotalCost(String item) {
        scannedItems.add(item);
        Item product =
            avaiableItems.stream().filter(availableItem -> availableItem.getName().equalsIgnoreCase(item)).findFirst().get();
        totalCost = getTotalCost(product);
        return totalCost;
    }

    private double getTotalCost(Item scannedItem) {
        String scannedItemName = scannedItem.getName();
        int group = Collections.frequency(scannedItems, scannedItemName);

        OfferItem offeritem = offerItems.stream().filter(
            offerItem -> (offerItem.getGroup() == group && offerItem.getItemName().equalsIgnoreCase(scannedItemName))).findFirst().orElse(null);

        double priceToReduce = scannedItem.getPrice() * (group - 1);
        if (offeritem != null) {
            scannedItems.removeIf(item -> item.equalsIgnoreCase(scannedItemName));
            totalCost = (totalCost - priceToReduce) + offeritem.getPrice();
        }
        else {
            totalCost = totalCost + scannedItem.getPrice();
        }
        return totalCost;
    }

}


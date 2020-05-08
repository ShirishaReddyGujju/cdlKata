package test.service;

import main.model.Item;
import main.model.OfferItem;
import main.service.AddItemPricingRules;
import main.service.AddOfferItemPricingRules;
import main.service.CostGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CostGeneratorImplTest {
    private static List<Item> avaiableItems;
    private static List<OfferItem> offerItems;
    private CostGenerator costGenerator;

    @BeforeEach
    public void setUp() {
        avaiableItems = AddItemPricingRules.getItemPricing();
        offerItems = AddOfferItemPricingRules.getOfferItemRules();
    }

    @Test
    void addSingleItemAndGetTotalCost() {
        String itemToAdd = "A";
        double expectedCost = avaiableItems.stream()
                                           .filter(item -> item.getName().equalsIgnoreCase(itemToAdd))
                                           .findFirst().get().getPrice();
        double actualCost = costGenerator.addItemAndGetTotalCost(itemToAdd);

        assertEquals(expectedCost, actualCost);
    }

    @Test
    void addMultipleItemAndGetTotalCost() {
        double expectedCost;
        double actualCost;
        List<String> itemsToAdd = new ArrayList<>();
        itemsToAdd.add("A");
        itemsToAdd.add("B");
        itemsToAdd.add("A");
        itemsToAdd.add("B");

        //Adding 1st item to the cart
        expectedCost = 50;
        actualCost = costGenerator.addItemAndGetTotalCost(itemsToAdd.get(0));
        assertEquals(expectedCost, actualCost, "Incorrect basket total price");

        //Adding 2nd item to the cart
        expectedCost = 80;
        actualCost = costGenerator.addItemAndGetTotalCost(itemsToAdd.get(1));
        assertEquals(expectedCost, actualCost, "Incorrect basket total price");

        //Adding 3rd item to the cart
        expectedCost = 130;
        actualCost = costGenerator.addItemAndGetTotalCost(itemsToAdd.get(2));
        assertEquals(expectedCost, actualCost, "Incorrect basket total price");

        //Adding 4th item to the cart
        expectedCost = 145;
        actualCost = costGenerator.addItemAndGetTotalCost(itemsToAdd.get(3));
        assertEquals(expectedCost, actualCost, "Incorrect basket total price, Offer not applied");
    }
}
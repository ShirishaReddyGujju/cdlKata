package service;

import model.Item;
import model.OfferItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.impl.CostGeneratorImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CostGeneratorImplTest {
    private static List<Item> avaiableItems;
    private static List<OfferItem> offerItems;
    CostGenerator costGenerator = new CostGeneratorImpl();


    @BeforeEach
    public void setUp() {
        generateMockPricingDetails();
    }

    /**
     * Mock data to run the tests for CostGenerator
     */
    private void generateMockPricingDetails() {
        AddItemPricingRules itemPricingRules = new AddItemPricingRules();
        itemPricingRules.addItemPricing("A",50);
        itemPricingRules.addItemPricing("B",30);
        itemPricingRules.addItemPricing("C",20);
        itemPricingRules.addItemPricing("D",15);
        avaiableItems  = itemPricingRules.getItemPricingList();

        AddOfferItemPricingRules offerItemPricingRules = new AddOfferItemPricingRules();
        offerItemPricingRules.addOfferItemPricing("A", 3, 130);
        offerItemPricingRules.addOfferItemPricing("B", 2, 45);
        offerItems = offerItemPricingRules.getOfferItemRules();
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
package service;


import model.Item;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddItemPricingRulesTest {
    AddItemPricingRules itemPricingRules = new AddItemPricingRules();

    @Test
    void addItemPricingRules(){
        itemPricingRules.addItemPricing("A",50);
        itemPricingRules.addItemPricing("B",30);
        itemPricingRules.addItemPricing("C",20);
        itemPricingRules.addItemPricing("D",15);
        List<Item> availableItems = itemPricingRules.getItemPricingList();

        assertAll(() -> assertNotNull(availableItems),
                  () -> assertEquals(availableItems.size(), 4),
                  () -> assertEquals(availableItems.get(0).getName(), "A"),
                  () -> assertEquals(availableItems.get(0).getPrice(), 50),
                  () -> assertEquals(availableItems.get(1).getName(), "B"),
                  () -> assertEquals(availableItems.get(1).getPrice(), 30),
                  () -> assertEquals(availableItems.get(2).getName(), "C"),
                  () -> assertEquals(availableItems.get(2).getPrice(), 20),
                  () -> assertEquals(availableItems.get(3).getName(), "D"),
                  () -> assertEquals(availableItems.get(3).getPrice(), 15)
                 );
    }
}
package test.service;

import main.model.Item;
import main.service.AddItemPricingRules;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddItemPricingRulesTest {

    @Test
    void getItemPricing(){
        List<Item> availableItems = AddItemPricingRules.getItemPricing();

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
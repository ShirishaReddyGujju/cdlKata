package service;

import model.OfferItem;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddOfferItemPricingRulesTest {
    AddOfferItemPricingRules offerItemPricingRules = new AddOfferItemPricingRules();

    @Test
    void addOfferItemPricingRules(){
        offerItemPricingRules.addOfferItemPricing("A", 3, 130);
        offerItemPricingRules.addOfferItemPricing("B", 2, 45);
        List<OfferItem> availableItemOffers = offerItemPricingRules.getOfferItemRules();

        assertAll(() -> assertNotNull(availableItemOffers),
                  () -> assertEquals(availableItemOffers.size(), 2),
                  () -> assertEquals(availableItemOffers.get(0).getItemName(), "A"),
                  () -> assertEquals(availableItemOffers.get(0).getGroup(), 3),
                  () -> assertEquals(availableItemOffers.get(0).getPrice(), 130),
                  () -> assertEquals(availableItemOffers.get(1).getItemName(), "B"),
                  () -> assertEquals(availableItemOffers.get(1).getGroup(), 2),
                  () -> assertEquals(availableItemOffers.get(1).getPrice(), 45)
                 );

    }
}
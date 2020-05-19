

import service.AddItemPricingRules;
import service.AddOfferItemPricingRules;
import service.CostGenerator;
import service.impl.CostGeneratorImpl;

import java.util.Scanner;

public class ItemController {
        private static CostGenerator costGenerator = new CostGeneratorImpl();
        private static AddItemPricingRules itemPricingRules = new AddItemPricingRules();
        private static AddOfferItemPricingRules offerItemPricingRules = new AddOfferItemPricingRules();

    public static void main(String args[]){
            double totalCost =0;
            itemPricingRules.addItemPricingRules();
            offerItemPricingRules.addOfferItemPricingRules();
            String scannedItem;
                Scanner sc = new Scanner(System.in);
                System.out.println("Please Scan your Item");
                while (sc.hasNext()) {
                    scannedItem = sc.next();
                    boolean isItemExists = costGenerator.validateIfItemExists(scannedItem);
                    if (scannedItem.equalsIgnoreCase("exit")) {
                        System.out.println("Total Cart Cost in pounds: " + totalCost / 100);
                        System.exit(0);
                    } else if(isItemExists) {
                        totalCost = costGenerator.addItemAndGetTotalCost(scannedItem);
                        System.out.println("Total Cart Cost in pounds: " + totalCost / 100);
                        System.out.println("Please Scan your Next Item or type exit to end the transaction");
                    } else {
                        System.out.println("Item you have Scanned not available");
                        System.out.println("Please Scan your Next Item or type exit to end the transaction");

                    }
                }
        }
}
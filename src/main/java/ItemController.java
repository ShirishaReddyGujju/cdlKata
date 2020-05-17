

import model.Item;
import service.AddItemPricingRules;
import service.AddOfferItemPricingRules;
import service.CostGenerator;
import service.impl.CostGeneratorImpl;

import java.util.Scanner;

public class ItemController {
        private static CostGenerator costGenerator = new CostGeneratorImpl();

        public static void main(String args[]){
            double totalCost =0;
            AddItemPricingRules.addItemPricingRules();
            AddOfferItemPricingRules.addOfferItemPricingRules();
            String scannedItem;
                Scanner sc = new Scanner(System.in);
                System.out.println("Please Scan your Item");
                while (sc.hasNext()) {
                    scannedItem = sc.next();
                    if (scannedItem.equalsIgnoreCase("exit")) {
                        System.out.println("Total Cart Cost in pounds: " + totalCost / 100);
                        System.exit(0);
                    } else {
                        totalCost = costGenerator.addItemAndGetTotalCost(scannedItem);
                        System.out.println("Total Cart Cost in pounds: " + totalCost / 100);
                        System.out.println("Please Scan your Next Item or type exit to end the transaction");
                    }
                }
        }




}
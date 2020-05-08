package main;

import main.service.CostGenerator;

import java.util.Scanner;

public class ItemController {
        private static CostGenerator costGenerator;

        public static void main(String args[]){
                Scanner sc = new Scanner(System.in);
                System.out.println("Please Scan your Item");
                while (sc.hasNext()) {
                        String scannedItem = sc.next();
                        double totalCost = costGenerator.addItemAndGetTotalCost(scannedItem);
                        System.out.println("Total Cart Cost : " + totalCost );
                        System.out.println("Please Scan your Next Item");
                }

        }

}

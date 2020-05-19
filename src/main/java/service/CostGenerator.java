package service;


public interface CostGenerator {

    double addItemAndGetTotalCost(String item);

    boolean validateIfItemExists(String item);
}

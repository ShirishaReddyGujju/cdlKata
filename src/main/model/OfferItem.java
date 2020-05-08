package main.model;

public class OfferItem {

    private String itemName;
    private int group;
    private double price;

    public OfferItem(String itemName, int group, double price) {
        this.itemName = itemName;
        this.group = group;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

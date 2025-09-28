package fr.epita.bank.datamodel;

public class Stock {
    String name;
    String currentPrice;

    public Stock(String name, String currentPrice) {
        this.name = name;
        this.currentPrice = currentPrice;
    }

    public String getName() {
        return name;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }
}

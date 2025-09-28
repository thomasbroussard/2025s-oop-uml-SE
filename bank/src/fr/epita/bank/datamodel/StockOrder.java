package fr.epita.bank.datamodel;

public class StockOrder {
    Double unitPrice;
    Integer quantity;
    Double commission;

    InvestmentAccount investmentAccount;
    Stock stock;

    public StockOrder(Double unitPrice, Integer quantity, Double commission,
                      InvestmentAccount investmentAccount, Stock stock) {
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.commission = commission;
        this.investmentAccount = investmentAccount;
        this.stock = stock;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getCommission() {
        return commission;
    }

    public Stock getStock() {
        return stock;
    }

}

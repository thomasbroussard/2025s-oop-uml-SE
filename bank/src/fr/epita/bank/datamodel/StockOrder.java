package fr.epita.bank.datamodel;

public class StockOrder {
    Double unitPrice;
    Integer quantity;
    Double commission;

    InvestmentAccount investmentAccount;
    Stock stock;


    public StockOrder(Integer quantity, Double commission, InvestmentAccount investmentAccount, Stock stock) {
        this.unitPrice = stock.getCurrentPrice();
        this.quantity = quantity;
        this.commission = commission;
        this.investmentAccount = investmentAccount;
        this.stock = stock;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public InvestmentAccount getInvestmentAccount() {
        return investmentAccount;
    }

    public void setInvestmentAccount(InvestmentAccount investmentAccount) {
        this.investmentAccount = investmentAccount;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}

package fr.epita.bank.services;

import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.Stock;
import fr.epita.bank.datamodel.StockOrder;

public class AccountService {

    private static final double COMMISSION = 0.004;

    public static StockOrder buyStocks(int quantity, Stock stock, InvestmentAccount investmentAccount) {
        StockOrder order = new StockOrder(quantity, COMMISSION, investmentAccount, stock);
        double final_price = (1 + order.getCommission()) * order.getUnitPrice() * order.getQuantity();
        investmentAccount.setBalance(investmentAccount.getBalance() - final_price);
        return order;
    }
}

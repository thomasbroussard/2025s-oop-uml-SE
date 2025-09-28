package fr.epita.bank.datamodel;

public class InvestmentAccount extends Account {

    public InvestmentAccount(String accountNumber, Double balance) {
        super(accountNumber, balance);
    }

    public void buyStock(Stock stock, int quantity, double commission) {
        double unitPrice = Double.parseDouble(stock.getCurrentPrice());
        double totalCost = (unitPrice * quantity) + commission;

        Double currentBalance = getBalance();

        if (currentBalance < totalCost) {
            System.out.println("Insufficient balance to buy stocks!");
            return;
        }


        System.out.println("Buying " + totalCost + " of " + stock.getName() + " from account " + getNumber());
        setBalance(currentBalance - totalCost);
    }

}

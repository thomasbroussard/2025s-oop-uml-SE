package fr.epita.bank.datamodel;

public class InvestmentAccount extends Account {

    public InvestmentAccount(String accountNumber, Double balance) {
        super(accountNumber, balance);
    }

    public void buyStock(String stockName, Double amount) {
        Double currentBalance = getBalance();

        if (currentBalance < amount) {
            System.out.println("Insufficient balance to buy stocks!");
            return;
        }

        System.out.println("Buying " + amount + " of " + stockName + " from account " + getNumber());
        setBalance(currentBalance - amount);
    }

}

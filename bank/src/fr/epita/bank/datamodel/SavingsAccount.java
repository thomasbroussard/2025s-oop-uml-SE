package fr.epita.bank.datamodel;
import fr.epita.bank.datamodel.Account;

public class SavingsAccount extends Account {
    Double interestRate;

    public SavingsAccount(String accountNumber, Double interestRate,  Double balance) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
}

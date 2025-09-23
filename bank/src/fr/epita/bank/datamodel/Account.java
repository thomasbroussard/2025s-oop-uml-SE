package fr.epita.bank.datamodel;

public class Account {
    String number;
    Double balance;

    protected Account(String number, double balance) {
        this.number = number;
        this.balance = balance;
    }


}

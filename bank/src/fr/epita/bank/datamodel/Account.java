package fr.epita.bank.datamodel;

public class Account {
    String number;
    Double balance;

    protected Account(String number, double balance) {
        this.number = number;
        this.balance = balance;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}

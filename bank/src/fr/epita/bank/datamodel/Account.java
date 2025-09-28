package fr.epita.bank.datamodel;

public class Account {
    private String number;
    private Double balance;

    protected Account(String number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}

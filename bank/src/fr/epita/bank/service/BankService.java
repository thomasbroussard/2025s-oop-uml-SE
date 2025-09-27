package fr.epita.bank.service;
import fr.epita.bank.datamodel.*;
import java.util.List;

public class BankService {
    private List<AccountCustomerAssignment> assignments;

    public BankService(List<AccountCustomerAssignment> assignments) {
        this.assignments = assignments;
    }

    private void createAssignment(String customerName, String customerAddress, Account account) {
        Customer customer = new Customer(customerName, customerAddress);

        AccountCustomerAssignment assignment = new AccountCustomerAssignment();
        assignment.setCustomer(customer);
        assignment.setAccount(account);

        assignments.add(assignment);

        System.out.println("Created assignment for " + customerName + " (" + account.getClass().getSimpleName() + ")");
    }

    public void createSavingsAssignment(String customerName, String customerAddress, String accountNumber, Double interestRate, Double balance) {
        SavingsAccount account = new SavingsAccount(accountNumber, interestRate, balance);
        createAssignment(customerName, customerAddress, account);
    }

    public void createInvestmentAssignment(String customerName, String customerAddress, String accountNumber, Double initialBalance) {
        InvestmentAccount account = new InvestmentAccount(accountNumber, initialBalance);
        createAssignment(customerName, customerAddress, account);
    }

    public void buyStock(InvestmentAccount account, String stockName, Double amount) {
        account.buyStock(stockName, amount);
    }

    public InvestmentAccount getFirstInvestmentAccount() {
        for (AccountCustomerAssignment acc : assignments) {
            if (acc.getAccount() instanceof InvestmentAccount) {
                return (InvestmentAccount) acc.getAccount();
            }
        }
        return null;
    }

    // Just in case to see, the assignments
    public void displayAssignments() {
        List<String> customerNames = assignments.stream()
                .map(a -> a.getCustomer().getName())
                .toList();

        customerNames.forEach(System.out::println);
    }


}

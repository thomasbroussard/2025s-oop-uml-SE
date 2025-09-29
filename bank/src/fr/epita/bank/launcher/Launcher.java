package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.*;
import fr.epita.bank.services.AccountService;

import java.util.ArrayList;
import java.util.List;

public class Launcher {




    public static void main(String[] args) {
        Customer customer = new Customer("test", "Paris");
        // customer.setName("test");
        // customer.setAddress("Paris");

        SavingsAccount savingsAccount = new SavingsAccount("test", 0.035, 400.0);

        AccountCustomerAssignment accountCustomerAssignment = new AccountCustomerAssignment(customer, savingsAccount);

        AccountCustomerAssignment[] customerAssignments = new AccountCustomerAssignment[2];

        List<AccountCustomerAssignment> assignments = new ArrayList<>();
        assignments.add(accountCustomerAssignment);

        //we will see that in a specific lecture
        assignments.stream()
                .map(a -> a.getCustomer().getName())
                .toList();

        Customer testCustomer2 = new Customer("test2", "Paris");

        InvestmentAccount investmentAccount = new InvestmentAccount("456", 2500);
        assignments.add(new AccountCustomerAssignment(testCustomer2, investmentAccount));

        Stock goldStock = new Stock("GOLD", 786d);


        int quantity = 2;

        AccountService accountService = new AccountService();
        AccountService.buyStocks(quantity, goldStock, investmentAccount);


    }



}

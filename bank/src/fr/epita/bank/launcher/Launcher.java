package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Account;
import fr.epita.bank.datamodel.AccountCustomerAssignment;
import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.SavingsAccount;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Launcher {


    public static void main(String[] args) {
        Customer customer = new Customer("test", "Paris");
        // customer.setName("test");
        // customer.setAddress("Paris");

        SavingsAccount savingsAccount = new SavingsAccount("test", 0.035, 400.0);

        AccountCustomerAssignment accountCustomerAssignment = new AccountCustomerAssignment();
        accountCustomerAssignment.setCustomer(customer);
        accountCustomerAssignment.setAccount(savingsAccount);

        AccountCustomerAssignment[] customerAssignments = new AccountCustomerAssignment[2];

        List<AccountCustomerAssignment> assignments = new ArrayList<>();
        assignments.add(accountCustomerAssignment);


        //we will see that in a specific lecture
        assignments.stream()
                .map(a -> a.getCustomer().getName())
                .toList();

        //1. assignment creation and addition (new customer + investment account)
        //2. buy stocks (to be created) from an investment account
        //3. figure out if a service creation is possible to gather all the actions present in the main method.





    }


}

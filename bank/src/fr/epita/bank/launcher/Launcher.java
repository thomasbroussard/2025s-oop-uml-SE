package fr.epita.bank.launcher;

import java.util.ArrayList;
import java.util.List;

import fr.epita.bank.datamodel.*;
import fr.epita.bank.service.BankService;


public class Launcher {


    public static void main(String[] args) {

        //3. figure out if a service creation is possible to gather all the actions present in the main method.
        // --------------------------
        // Yes, the service is created. Here, we just created fr.epita.bank.service.BankService
        // to handle all actions from the main method in a centralized and reusable way.
        // --------------------------

        List<AccountCustomerAssignment> assignments = new ArrayList<>();
        BankService bankService = new BankService(assignments);

        bankService.createSavingsAssignment("test", "Paris", "test", 0.035, 400.0);

          // --------------------------------------------------
          // 1. Assignment creation and addition
          // (new customer + investment account)
          // --------------------------------------------------
        bankService.createInvestmentAssignment("Naveed", "Epita", "INV-001", 10.0);

        // --------------------------------------------------
        // 2. buy stocks (to be created) from an investment account
        // --------------------------------------------------
        InvestmentAccount invAcc = bankService.getFirstInvestmentAccount();
        if(invAcc != null){
            Stock apple = new Stock("AAPL", "2");
            Stock google = new Stock("GOOGL", "2800");

            bankService.buyStock(invAcc, apple, 1, 2.0);
            bankService.buyStock(invAcc, google, 2, 15.0);
        }

        bankService.displayAssignments();

    }


}

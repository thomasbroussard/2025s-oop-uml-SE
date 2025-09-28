package fr.epita.bank.launcher;

import java.util.ArrayList;
import java.util.List;

import fr.epita.bank.datamodel.*;
import fr.epita.bank.services.*;


public class Launcher {


    public static void main(String[] args) {

        // Service layer implementation complete
        // Q: Is service creation possible to gather main method actions?
        // A: Yes - ServiceBank class now centrally manages all banking operations

        List<AccountCustomerAssignment> assignments = new ArrayList<>();
        ServiceBank ServiceBank = new ServiceBank(assignments);

        ServiceBank.createSavingsAssignment("Test User", "Paris", "SAVACC-001", 0.035, 400.0);

        // --------------------------------------------------
        // Step 1: Create new customer with investment account
        // --------------------------------------------------
        ServiceBank.createInvestmentAssignment("Naveed Riaz", "Epita, Paris", "INVACC-001", 10.0);

        // --------------------------------------------------
        // Step 2: Purchase stocks via investment account
        // --------------------------------------------------
        InvestmentAccount invAcc = ServiceBank.getFirstInvestmentAccount();
        if(invAcc != null){
            ServiceBank.buyStock(invAcc, "TESLA", 5.0);
            ServiceBank.buyStock(invAcc, "Microsoft", 2.0);
        }

        ServiceBank.displayAssignments();

    }


}
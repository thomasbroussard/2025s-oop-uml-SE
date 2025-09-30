package fr.epita.biostat.launcher;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Scanner sc = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = sc.nextLine();

        System.out.println("your name is " + name);

        System.out.println("What is your age?");
        String age = sc.nextLine();
        try {
            Integer.parseInt(age);
        }catch (NumberFormatException e) {
            //TODO handle error message, and loop until we have a proper input?
            e.printStackTrace();
        }
        System.out.println("your age is " + age);
        sc.close();

    }
}

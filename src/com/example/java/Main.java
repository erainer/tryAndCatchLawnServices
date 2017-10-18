package com.example.java;
import java.io.IOException;
import java.util.InputMismatchException;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean senior = false;
        String phone = "";
        String name = "";
        String address = "";
        double sqft = 0.0;
        int answer = 0;
        int many = 0;
        String pName = "";
        boolean multiple = false;
        Customer cust = new Customer(name, phone, address, sqft);

        //validates the users menu choice until they choose exit.
        do {
            do {
                //get users input
                System.out.println("Welcome to Emily's Lawn Service");
                System.out.println("1. Residential Customer\n2. Commercial Customer\n3. Exit");
                choice = scanner.nextInt();
                if (choice != 1 && choice != 2)
                    System.out.println("Invalid menu choice, try again.");
            } while (choice != 1 && choice != 2);

            try {
                System.out.println("What is your name?");
                name = scanner.next();
            } catch (NullPointerException exception) {
                System.out.println("You didn't enter anything for your name.");
            }

            try {
                System.out.println("What is your phone number? No dashes just 10 digits");
                phone = scanner.next();
            } catch (InputMismatchException exception) {
                System.out.println("Not a valid phone number");
            }

            try {
                System.out.println("What is your address?");
                scanner.nextLine();
                address = scanner.nextLine();
            } catch (NullPointerException exception){
                System.out.println("You didn't enter anything for your address.");
            }

            try {
                System.out.println("How many square feet is your lawn?");
                sqft = scanner.nextDouble();
            } catch (InputMismatchException exception) {
                System.out.println("Can't have letters for the footage");
            }

            //creates a residential object
            Residential res = new Residential(senior, name, phone, address, sqft, answer);
            //creates a commerical object
            Commercial com = new Commercial(pName, multiple, name, phone, address, sqft);
            //determines the choice made from menu
            if (choice == 1) {
                try {
                    System.out.println("What is your age?");
                    answer = scanner.nextInt();
                } catch (InputMismatchException exception) {
                    System.out.println("You didn't enter a number for your age.");
                    senior = false;
                }

                //calls a function from residential class
                res.calulate(senior, name, phone, address, sqft);

            } else if (choice == 2) {
                try {
                    System.out.println("What is your property name?");
                    scanner.nextLine();
                    pName = scanner.next();
                } catch (NullPointerException exception) {
                    System.out.println("You didn't enter anything for your property name");
                }
                try {
                    System.out.println("How many properties do you have?");
                    many = scanner.nextInt();
                } catch (InputMismatchException exception) {
                    System.out.println("You can only have numbers as an answer, auto disquilified for multiple properties discount.");
                }
                //calls a function from the commercial class
                com.calulate(multiple, name, phone, address, sqft);
            }
        } while (choice != 3);
    }
}
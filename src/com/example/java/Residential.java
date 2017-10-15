package com.example.java;

import java.text.NumberFormat;
import java.util.Locale;

public class Residential extends Customer {
    static double residentialRate;
    boolean senior;
    int answer;
    //constructor
    public Residential(boolean senior, String name, String phone, String address, double footage, int answer){
        super(name, phone, address, footage);
        this.residentialRate = 6.0;
        this.senior = senior;
        this.answer = answer;
    }

    public boolean getSenior(){
        return this.senior;
    }

    public void setSenior(int answer) throws IndexOutOfBoundsException {
        //determines the senior discount
        if (answer >= 60) {
            senior = true;
        } else if (answer < 60 && answer > 0) {
            System.out.println("You don't qualify for any discounts.");
            senior = false;
        }else if(answer < 0){
            throw new IndexOutOfBoundsException();
        }
        this.senior = senior;
    }

    //calculates the total cost of the lawn service for residential customers
    public void calulate(boolean senior, String name, String phone, String address, double footage){
        double costByCommericalRate = 0.0;
        double costBySqFt = 0.0;
        double extraSqFt = 0.0;
        double extraSqFtCost = 0.0;
        double discount = 0.0;
        double totalCost = 0.0;

        extraSqFt = squareFootage % 1000;
        //calculates the square footage
        if(extraSqFt > 0){
            costBySqFt = residentialRate / 1000;
            extraSqFtCost = extraSqFt * costBySqFt;
        }
        costByCommericalRate = (squareFootage/1000)*residentialRate;
        totalCost = costByCommericalRate + extraSqFtCost;
        //calculates the senior discount
        if(senior){
            discount = .15 * totalCost;
            totalCost = discount - totalCost;
            if(totalCost <= 0)
                totalCost = 0;
        }
        //prints out information
        if(senior)
            System.out.println("Senior discount of 15% was applied.");

        System.out.println("Customer Name: " + name);
        System.out.println("Customer Phone number: " + phone);
        System.out.println("Customer Address: " + address);
        System.out.println("Square footage: " + footage);
        System.out.println("Total cost of the lawn service: " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(totalCost) + "\n");
    }
}

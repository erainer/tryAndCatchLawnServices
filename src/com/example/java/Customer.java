package com.example.java;

public class Customer {
    public String customerName;
    public String customerPhone;
    public String customerAddress;
    public double squareFootage;
    //constructor
    public Customer(String name, String phone, String address, double footage) {
        this.customerName = name;
        this.customerPhone = phone;
        this.customerAddress = address;
        this.squareFootage = footage;
    }
    //gets name
    public String getName() {
        return customerName;
    }
    //sets name
    public void setName(String name)  throws NullPointerException {
        //checks the amount of characters in name
        if(customerName == null)
            throw new NullPointerException();
        this.customerName = name;
    }

    //gets phone number
    public String getPhone(){
        return customerPhone;
    }

    //sets phone number
    public void setPhone(String phone)throws IndexOutOfBoundsException {
        //Check the phone number before it prints
        int phoneNum = Integer.parseInt(customerPhone);
        if(phoneNum > 10 || phoneNum < 10)
            throw new IndexOutOfBoundsException();
        this.customerPhone = phone;
    }

    //gets address
    public String getAddress(){
        return customerAddress;
    }
    //sets address
    public void setAddress(String address) throws NullPointerException {
        //checks the amount of characters in address
        if(customerAddress == null)
            throw new NullPointerException();
        this.customerAddress = address;
    }

    //gets footage
    public Double getFootage() {
        return squareFootage;
    }
    //sets footage
    public void setFootage(double footage) throws IllegalArgumentException{
        String number = Double.toString(squareFootage);
        if (number.contains("[a-z]+")) {
            throw new IllegalArgumentException();
        }
        this.squareFootage = footage;
    }


}

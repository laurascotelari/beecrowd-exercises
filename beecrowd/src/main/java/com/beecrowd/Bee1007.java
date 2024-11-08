package com.beecrowd;

public class Bee1007 {

    public static double calcSalary(int hours, double amount) {
        if(hours < 0 || amount < 0){
            throw new IllegalArgumentException("Working hours and amount can't be negative");
        }
        return hours * amount;
    }
    
}

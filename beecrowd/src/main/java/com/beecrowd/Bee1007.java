package com.beecrowd;

import java.util.Scanner;

public class Bee1007 {

    public static void main(){
        Scanner in = new Scanner(System.in);
        
        int number = in.nextInt();
        int hours = in.nextInt();
        double amount = in.nextDouble();

        double salary = calcSalary(hours, amount);

        System.out.printf("NUMBER = %d\nSALARY = %.3f\n", number, salary);
        in.close();
    }

    public static double calcSalary(int hours, double amount) {
        if(hours < 0 || amount < 0){
            throw new IllegalArgumentException("Working hours and amount can't be negative");
        }
        return hours * amount;
    }
    
}

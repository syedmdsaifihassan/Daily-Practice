//Operators

/*
Objective
In this challenge, you will work with arithmetic operators.

Task
Given the meal price (base cost of a meal), tip percent (the percentage of the meal price being added as tip), and tax percent (the percentage of the meal price being added as tax) for a meal, find and print the meal's total cost. Round the result to the nearest integer.

Example
meal cost=100
tip percent=15
tax percent=8


A tip of 15% * 100 = 15, and the taxes are 8% * 100 = 8. Print the value 123 and return from the function.

Function Description
Complete the solve function in the editor below.

solve has the following parameters:

int meal_cost: the cost of food before tip and tax
int tip_percent: the tip percentage
int tax_percent: the tax percentage
Returns The function returns nothing. Print the calculated value, rounded to the nearest integer.

Note: Be sure to use precise values for your calculations, or you may end up with an incorrectly rounded result.

Input Format

There are  lines of numeric input:
The first line has a double, meal cost (the cost of the meal before tax and tip).
The second line has an integer, tip percent (the percentage of meal cost being added as tip).
The third line has an integer, tax percent (the percentage of meal cost being added as tax).

Sample Input

12.00
20
8
Sample Output

15
Explanation

Given:
meal_cost=12, tip_percent=20 , tax_percent=8

Calculations:
tip=12 and (12/100)*20=2.4
tax=8 and (8/100)*20=0.96
total_cost=meal_cost+tip+tax=12+2.4+0.96=15.36
round(total_cost)=15

We round total_cost to the nearest integer and print the result, 15.
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the solve function below.
    static void solve(double meal_cost, int tip_percent, int tax_percent) {
        
        double total;
        
        
        total = meal_cost + meal_cost*tip_percent/100 + meal_cost*tax_percent/100;
        
        System.out.println(Math.round(total));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double meal_cost = scanner.nextDouble();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int tip_percent = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int tax_percent = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        solve(meal_cost, tip_percent, tax_percent);

        scanner.close();
    }
}

/*
Test Case 0

Input (stdin)

12.00
20
8

Expected Output

15
---------------

Test Case 1

Input (stdin)

15.50
15
10

Expected Output

19

*/
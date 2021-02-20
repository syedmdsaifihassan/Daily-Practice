//INTERFACES

/*
Objective
Today, we're learning about Interfaces.

Task
The AdvancedArithmetic interface and the method declaration for the abstract divisorSum(n) method are provided for you in the editor below.

Complete the implementation of Calculator class, which implements the AdvancedArithmetic interface. The implementation for the divisorSum(n) method must return the sum of all divisors of n.

Input Format

A single line containing an integer, n.

Constraints
1 <= n <= 1000

Output Format

You are not responsible for printing anything to stdout. The locked template code in the editor below will call your code and print the necessary output.

Sample Input

6

Sample Output

I implemented: AdvancedArithmetic
12

Explanation

The integer 6 is evenly divisible by 1, 2, 3, and 6. Our divisorSum method should return the sum of these numbers, which is 1+2+3+6=12. The Solution class then prints I implemented: AdvancedArithmetic on the first line, followed by the sum returned by divisorSum (which is 12) on the second line.
*/

import java.io.*;
import java.util.*;

interface AdvancedArithmetic{
   int divisorSum(int n);
}
class Calculator implements AdvancedArithmetic
{ 
    public int divisorSum(int n)
    {
        int sum = n;
        for(int x=1;x<=n/2;x++)
        {
            if(n%x==0)
            {
            sum = sum + x;
            }
        }
        return sum;
    } 
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        
      	AdvancedArithmetic myCalculator = new Calculator(); 
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }
}
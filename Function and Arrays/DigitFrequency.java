/*
Digit Frequency

1. You are given a number n.
2. You are given a digit d.
3. You are required to calculate the frequency of digit d in number n.

Input Format
A number n
A digit d

Output Format
A number representing frequency of digit d in number n

Constraints
0 <= n <= 10^9
0 <= d <= 9
  
Sample Input
994543234
4

Sample Output
3

*/

import java.util.*;

public class DigitFrequency {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();
        int f = getDigitFrequency(n, d);
        System.out.println(f);
    }

    public static int getDigitFrequency(int n, int d) {
        // write code here
        int c=0;
        int r;
        while(n!=0){
            r=n%10;
            if(r==d) {
                c++;
            }
            n=n/10;
        }
        return c;
    }
}
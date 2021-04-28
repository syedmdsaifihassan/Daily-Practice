/*
339A. Helpful Maths
time limit per test: 2 seconds
memory limit per test: 256 megabytes
input: standard input
output: standard output

Xenia the beginner mathematician is a third year student at elementary school. She is now learning the addition operation.

The teacher has written down the sum of multiple numbers. Pupils should calculate the sum. To make the calculation easier, the sum only contains numbers 1, 2 and 3. Still, that isn't enough for Xenia. She is only beginning to count, so she can calculate a sum only if the summands follow in non-decreasing order. For example, she can't calculate sum 1+3+2+1 but she can calculate sums 1+1+2 and 3+3.

You've got the sum that was written on the board. Rearrange the summans and print the sum in such a way that Xenia can calculate the sum.

Input
The first line contains a non-empty string s — the sum Xenia needs to count. String s contains no spaces. It only contains digits and characters "+". Besides, string s is a correct sum of numbers 1, 2 and 3. String s is at most 100 characters long.

Output
Print the new sum that Xenia can count.

Examples
input
3+2+1
output
1+2+3

input
1+1+3+1+3
output
1+1+1+3+3

input
2
output
2

*/

import java.util.Arrays;
import java.util.Scanner;

public class HelpfulMaths {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char[] sar = s.toCharArray();
        int n=(sar.length/2)+1;
        char[] arr = new char[n];
        int j=0;
        for (int i = 0; i < sar.length; i+=2) {
            arr[j]=sar[i];
            j++;
        }
        Arrays.sort(arr);

        char[] sar2 = new char[sar.length];
        Arrays.fill(sar2, '+');
        int k=0;
        for (int i = 0; i < sar2.length; i+=2) {
            sar2[i]=arr[k];
            k++;
        }
        for (int i = 0; i < sar2.length; i++) {
            System.out.print(sar2[i]);
        }
    }
}

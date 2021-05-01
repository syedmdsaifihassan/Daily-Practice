/*
266A. Stones on the Table
time limit per test: 2 seconds
memory limit per test: 256 megabytes
input: standard input
output: standard output

There are n stones on the table in a row, each of them can be red, green or blue. Count the minimum number of stones to take from the table so that any two neighboring stones had different colors. Stones in a row are considered neighboring if there are no other stones between them.

Input
The first line contains integer n (1 ≤ n ≤ 50) — the number of stones on the table.

The next line contains string s, which represents the colors of the stones. We'll consider the stones in the row numbered from 1 to n from left to right. Then the i-th character s equals "R", if the i-th stone is red, "G", if it's green and "B", if it's blue.

Output
Print a single integer — the answer to the problem.

Examples
input
3
RRG
output
1

input
5
RRRRR
output
4

input
4
BRBG
output
0

*/

import java.util.Scanner;

public class StonesontheTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String str=sc.nextLine();
        int itr=0;
        for (int i = 0; i < n-1; i++) {
            char c=str.charAt(i);
            char d=str.charAt(i+1);
            if(c==d) {
                itr++;
            }
        }
        System.out.println(itr);
    }
}

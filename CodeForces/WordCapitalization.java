/*
A. Word Capitalization
time limit per test: 2 seconds
memory limit per test: 256 megabytes
input: standard input
output: standard output

Capitalization is writing a word with its first letter as a capital letter. Your task is to capitalize the given word.

Note, that during capitalization all the letters except the first one remains unchanged.

Input
A single line contains a non-empty word. This word consists of lowercase and uppercase English letters. The length of the word will not exceed 103.

Output
Output the given word after capitalization.

Examples
input
ApPLe
output
ApPLe

input
konjac
output
Konjac

*/

import java.util.Scanner;

public class WordCapitalization {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();

        char temp=s.charAt(0);
        char temp2=Character.toUpperCase(temp);
        System.out.println(temp2+""+s.substring(1,n));
    }
}

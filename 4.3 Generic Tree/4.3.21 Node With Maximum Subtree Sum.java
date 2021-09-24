/*
Node With Maximum Subtree Sum
Medium

1. You are given a partially written GenericTree class.
2. You are required to find and print the node which has the subtree with largest sum. Also print the sum of the concerned subtree separated from node's value by an '@'.

Sample Input
20
10 20 -50 -1 60 -1 -1 30 -70 -1 80 -1 90 -1 -1 40 -100 -1 -1 -1

Sample Output
30@130

*/

import java.io.*;
import java.util.*;

public class Main {
    
    public static class Pair{
        int sum;
        int msSum = Integer.MIN_VALUE;
        Node msNode;
    }
    
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }
    // static int maxSubSum = Integer.MIN_VALUE;
    // static Node maxSubSumNode;
    // public static int nodeWithMaxSubtreeSum(Node node){
    //     // write your code here
    //     int sum = node.data;
    //     for(Node child: node.children){
    //         sum += nodeWithMaxSubtreeSum(child);
    //     }
    //     if(maxSubSum<sum){
    //         maxSubSum = sum;
    //         maxSubSumNode = node;
    //     }
        
    //     return sum;
    // }

    public static Pair fun(Node node){
        Pair mp = new Pair();
        mp.sum += node.data;
        
        for(Node child: node.children){
            Pair cp = fun(child);
            mp.sum+=cp.sum;
            
            if(cp.msSum>mp.msSum){
                mp.msSum = cp.msSum;
                mp.msNode = cp.msNode;
            }
        }
        if(mp.sum>mp.msSum){
            mp.msSum = mp.sum;
            mp.msNode = node;
        }
        return mp;
    }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    // write your code here
    // nodeWithMaxSubtreeSum(root);
    // System.out.println(maxSubSumNode.data+"@"+maxSubSum);
    
    Pair ans = fun(root);
    System.out.println(ans.msNode.data+"@"+ans.msSum);
  }

}
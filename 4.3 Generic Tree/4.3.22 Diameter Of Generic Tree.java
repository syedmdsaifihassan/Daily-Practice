/*
Diameter Of Generic Tree
Mediu

1. You are given a partially written GenericTree class.
2. You are required to find and print the diameter of tree. THe diameter is defined as maximum number of edges between any two nodes in the tree.

Sample Input
20
10 20 -50 -1 60 -1 -1 30 -70 -1 80 -1 90 -1 -1 40 -100 -1 -1 -1

Sample Output
4

*/

import java.io.*;
import java.util.*;

public class Main {
    
    // Approach 2 (Pair)
    public static class Pair{
        int h;
        int d;
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

  // Approach 1 (Travel & change)
//   static int diameter;
//   public static int height(Node node){
//       int maxh=-1;
//       int smaxh = -1;
      
//       for(Node child: node.children){
//           int ch = height(child);
//           if(ch>maxh){
//               smaxh = maxh;
//               maxh = ch;
//           }else if(ch>smaxh){
//               smaxh = ch;
//           }
//       }
      
//       diameter = Math.max(diameter, maxh+smaxh+2);
//       return maxh+1;
//   }

    // Approach 2 (Pair)
    public static Pair diameter(Node node){
        int maxh = -1;
        int smaxh = -1;
        int d = 0;
        for(Node child: node.children){
            Pair cp = diameter(child);
            if(cp.h>maxh){
                smaxh = maxh;
                maxh = cp.h;
            }else if(cp.h>smaxh){
                smaxh = cp.h;
            }
            d = Math.max(d, cp.d);
        }
        Pair mp = new Pair();
        mp.h = maxh+1;
        mp.d = Math.max(d, maxh+smaxh+2);
        
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
    // Approach 1
    // height(root);
    // System.out.println(diameter);
    
    // Approach 2
    Pair ap = diameter(root);
    System.out.println(ap.d);
  }

}
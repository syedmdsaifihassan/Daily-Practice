/*
Iterative Preorder And Postorder Of Generic Tree
Medium

1. You are given a partially written GenericTree class.
2. You are require to complete the body of function IterativePreandPostOrder. The function does not use recursion and prints preorder and postorder of the tree. Both orders are printed in separate lines (preorder first, followed by post order in next line). Elements in an order are separated by space.

Sample Input
24
10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1

Sample Output
10 20 -50 60 30 70 -80 110 -120 90 40 -100 
-50 60 20 70 110 -120 -80 90 30 -100 40 10 

*/

import java.io.*;
import java.util.*;

public class Main {
    
    public static class Pair{
        int state;
        Node node;
        
        public Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
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

  public static void IterativePreandPostOrder(Node node) {
    // write your code here
    String preOrder = "";
    String postOrder = "";
    Stack<Pair> st = new Stack<>();
    Pair p = new Pair(node, 0);
    st.push(p);
    
    while(st.size()>0){
        Pair t = st.peek();
        if(t.state == 0){
            preOrder += t.node.data+" ";
            if(t.node.children.size() > 0){
                Pair cp = new Pair(t.node.children.get(0), 0);
                st.push(cp);
            }
            t.state++;
        }else if(t.state >= t.node.children.size()){
            postOrder += t.node.data+" ";
            st.pop();
        }else{
            Pair cp = new Pair(t.node.children.get(t.state), 0);
            st.push(cp);
            t.state++;
        }
    }
    System.out.println(preOrder);
    System.out.println(postOrder);
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
    IterativePreandPostOrder(root);
  }

}
/*
Remove Node From Bst
Medium  Prev   Next
1. You are given a partially written BST class.
2. You are required to complete the body of remove function. "remove" function is expected to remove a new node with given data to the tree and return the new root.

Sample Input
15
50 25 12 n n 37 n n 75 62 n n 87 n n
62

Sample Output
25 <- 50 -> 75
12 <- 25 -> 37
. <- 12 -> .
. <- 37 -> .
. <- 75 -> 87
. <- 87 -> .

Asked in Companies
Microsoft       6
Amazon      2
cisco       2
Oracle      2

*/

import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static int max(Node node) {
    // write your code here
    // if(node == null){
    //     return Integer.MIN_VALUE;
    // }
    // int lmax = max(node.left);
    // int rmax = max(node.right);
    // int maximum = Math.max(node.data, Math.max(lmax, rmax));
    // return maximum;
    
    if(node.right == null){
        return node.data;
    }else{
        return max(node.right);
    }
  }

  public static Node remove(Node node, int data) {
    // write your code here
    if(node == null) return null;

    if(node.data == data){
        if(node.left==null && node.right==null){    //leaf node
            return null;
        }else if(node.left==null){      //node with single child
            return node.right;
        }else if(node.right==null){     //node with single child
            return node.left;
        }else if(node.left!=null && node.right!=null){  //both children
            int lmax = max(node.left);
            node.data = lmax;
            node.left = remove(node.left, lmax);
        }
    }else if(node.data<data){
        node.right = remove(node.right, data);
    }else{
        node.left = remove(node.left, data);
    }

    return node;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    root = remove(root, data);

    display(root);
  }

}
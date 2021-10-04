/*
Size, Sum, Max, Min, Find In Bst

1. You are given a partially written BST class.
2. You are required to complete the body of size, sum, max, min and find function. The functions are expected to:
    2.1. size - return the number of nodes in BST
    2.2. sum - return the sum of nodes in BST
    2.3. max - return the value of node with greatest value in BST
    2.4. min - return the value of node with smallest value in BST
    2.5. find - return true if there is node in the tree equal to "data"

Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
70

Sample Output
9
448
87
12
true

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

  public static int size(Node node) {
    // write your code here
    if(node == null){
        return 0;
    }
    
    int lsize = size(node.left);
    int rsize = size(node.right);
    int s = lsize+rsize+1;
    
    return s;
  }

  public static int sum(Node node) {
    // write your code here
    if(node == null){
        return 0;
    }
    
    int lsum = sum(node.left);
    int rsum = sum(node.right);
    int totalSum = lsum+rsum+node.data;
    
    return totalSum;
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

  public static int min(Node node) {
    // write your code here
    // if(node == null){
    //     return Integer.MAX_VALUE;
    // }
    // int lmin = min(node.left);
    // int rmin = min(node.right);
    // int minimum = Math.min(node.data, Math.min(lmin, rmin));
    // return minimum;
    
    if(node.left == null){
        return node.data;
    }else{
        return min(node.left);
    }
  }

  public static boolean find(Node node, int data){
    // write your code here
    // if(node == null){
    //     return false;
    // }
    // if(node.data == data) return true;
    // boolean lans = find(node.left, data);
    // if(lans == true) return true;
    // boolean rans = find(node.right, data);
    // if(rans == true) return true;
    // return false;
    
    if(node == null){
        return false;
    }
    if(node.data<data){
        return find(node.right, data);
    }else if(node.data>data){
        return find(node.left, data);
    }else{
        return true;
    }
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

    int size = size(root);
    int sum = sum(root);
    int max = max(root);
    int min = min(root);
    boolean found = find(root, data);

    System.out.println(size);
    System.out.println(sum);
    System.out.println(max);
    System.out.println(min);
    System.out.println(found);
  }

}

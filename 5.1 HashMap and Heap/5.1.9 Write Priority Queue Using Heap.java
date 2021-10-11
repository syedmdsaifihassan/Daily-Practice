/*
Write Priority Queue Using Heap
Easy

1. You are required to complete the code of our Priority Queue class using the heap data structure. Please watch the question video carefully. The theoretical details of required functionality is explained in detail there. Implement the functions to achieve what is explained in the theoretical discussion in question video.
2. Here is the list of functions that you are supposed to complete:
    2.1. add -> Should accept new data.
    2.2. remove -> Should remove and return smallest value, if available or print 
     "Underflow" otherwise and return -1.
     2.3. peek -> Should return smallest value, if available or print "Underflow" 
     otherwise and return -1.
     2.4. size -> Should return the number of elements available.

Sample Input
add 10
add 20
add 30
add 40
peek
add 50
peek
remove
peek
remove
peek
remove
peek
remove
peek
quit

Sample Output
10
10
10
20
20
30
30
40
40
50

*/

import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }
    
    // Heap Constructor
    // input taken in array (when array elements are given)
    // public PriorityQueue(int[] arr){
    //     data = new ArrayList<>();
    //     for(int i=0; i<arr.length; i++){
    //         data.add(arr[i]);
    //     }
        
    //     for(int i=(data.size()-2)/2; i>=0; i--){
    //         downheapify(i);
    //     }
    // }

    public void add(int val) {
      // write your code here
      data.add(val);
      upheapify(data.size()-1);
    }
    
    public void upheapify(int ci){
        if(ci==0){
            return;
        }
        
        int pi = (ci-1)/2;
        if(data.get(ci)<data.get(pi)){
            swap(ci, pi);
            upheapify(pi);
        }
    }
    
    public void swap(int i, int j){
        int ith = data.get(i);
        int jth = data.get(j);
        data.set(i, jth);
        data.set(j, ith);
    }

    public int remove() {
      // write your code here
      if(data.size()==0){
          System.out.println("Underflow");
          return -1;
      }
      
      swap(0, data.size()-1);
      int rv = data.remove(data.size()-1);
      
      downheapify(0);
      return rv;
    }
    
    public void downheapify(int pi){
        int lci = 2*pi+1;
        int rci = 2*pi+2;
        
        int minidx = pi;
        if(lci<data.size() && data.get(lci)<data.get(minidx)){
            minidx = lci;
        }
        if(rci<data.size() && data.get(rci)<data.get(minidx)){
            minidx = rci;
        }
        
        if(minidx!=pi){
            swap(pi, minidx);
            downheapify(minidx);
        }
    }

    public int peek() {
      // write your code here
      if(data.size()==0){
          System.out.println("Underflow");
          return -1;
      }
      
      return data.get(0);
    }

    public int size() {
      // write your code here
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
    
    // when elements of array are given
    // int[] arr = {12, 18, 11, 10, 280, -2, -56, 829, -822};
    // PriorityQueue qu = new PriorityQueue(arr);
    // while(qu.size()!=0){
    //     System.out.println(qu.remove());
    // }
  }
}
/*
Median Priority Queue
Hard
1. You are required to complete the code of our MedianPriorityQueue class. The class should mimic the behaviour of a PriorityQueue and give highest priority to median of it's data.
2. Here is the list of functions that you are supposed to complete
2.1. add -> Should accept new data.
2.2. remove -> Should remove and return median value, if available or print "Underflow" otherwise and return -1
2.3. peek -> Should return median value, if available or print "Underflow" otherwise and return -1
2.4. size -> Should return the number of elements available
3. Input and Output is managed for you.

Note -> If there are even number of elements in the MedianPriorityQueue, consider the smaller median as median value.

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
20
30
30
20
20
40
40
10
10
50


Asked in Companies
Microsoft       10
Adobe       2
Google      6
Amazon      17
Goldman Sachs       15
Oracle      2
Facebook        5
Apple       1
Bloomberg       4
ByteDance       2

*/

import java.io.*;
import java.util.*;

public class Main {

  public static class MedianPriorityQueue {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianPriorityQueue() {
      left = new PriorityQueue<>(Collections.reverseOrder());
      right = new PriorityQueue<>();
    }

    public void add(int val) {
      // write your code here
      if(left.size()==0&&right.size()==0){
          left.add(val);
      }else if(left.size()==0){
          if(val<right.peek()){
              left.add(val);
          }else{
              right.add(val);
          }
      }else{
          if(val<left.peek()){
              left.add(val);
          }else{
              right.add(val);
          }
      }
      
      int diff = Math.abs(left.size()-right.size());
      if(diff>1){
          if(left.size()>right.size()){
              right.add(left.remove());
          }else{
              left.add(right.remove());
          }
      }
    }

    public int remove() {
      // write your code here
      if(right.size()+left.size()==0){
          System.out.println("Underflow");
          return -1;
      }
      if(left.size()>=right.size()){
          return left.remove();
      }else{
          return right.remove();
      }
    }

    public int peek() {
      // write your code here
      if(left.size()+right.size()<=0){
          System.out.println("Underflow");
          return -1;
      }
      if(left.size()>=right.size()){
          return left.peek();
      }else{
          return right.peek();
      }
    }

    public int size() {
      // write your code here
      return right.size()+left.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MedianPriorityQueue qu = new MedianPriorityQueue();

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
  }
}
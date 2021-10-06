/*
Merge K Sorted Lists
Hard
1. You are given a list of lists, where each list is sorted.
2. You are required to complete the body of mergeKSortedLists function. The function is expected to merge k sorted lists to create one sorted list.

Constraints
Space complextiy = O(k)
Time complexity = nlogk
where k is the number of lists and n is number of elements across all lists.

Sample Input
4
5
10 20 30 40 50
7
5 7 9 11 19 55 57
3
1 2 3
2
32 39

Sample Output
1 2 3 5 7 9 10 11 19 20 30 32 39 40 50 55 57 


Asked in Companies
Microsoft       12
Adobe       2
Google      3
Amazon      69
Uber        4
Oracle      4
Facebook        49
Apple       8
Bloomberg       4
eBay        3
ByteDance       2
VMware      2
Lyft        2
Nvidia      2

*/

import java.io.*;
import java.util.*;

public class Main {
    
    public static class Pair implements Comparable<Pair>{
        int data;
        int li;
        int di;
        public Pair(int data, int li, int di){
            this.data = data;
            this.li = li;
            this.di = di;
        }
        
        public int compareTo(Pair other){
            return data-other.data;
        }
    }
    
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> ans = new ArrayList<>();

      // write your code here
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      for(int i=0; i<lists.size(); i++){
          ArrayList<Integer> al = lists.get(i);
          pq.add(new Pair(al.get(0),i,0));
      }
      
      while(pq.size()!=0){
          Pair rp = pq.remove();
          ans.add(rp.data);
          if(rp.di+1<lists.get(rp.li).size()){
              pq.add(new Pair(lists.get(rp.li).get(rp.di+1), rp.li, rp.di+1));
          }
      }

      return ans;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}
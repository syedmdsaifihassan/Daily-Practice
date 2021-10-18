/*
Perfect Friends
Easy
1. You are given a number n (representing the number of students). Each student will have an id 
     from 0 to n - 1.
2. You are given a number k (representing the number of clubs)
3. In the next k lines, two numbers are given separated by a space. The numbers are ids of 
     students belonging to same club.
4. You have to find in how many ways can we select a pair of students such that both students are 
     from different clubs.

Sample Input
7
5
0 1
2 3
4 5
5 6
4 6

Sample Output
16

*/

import java.io.*;
import java.util.*;

public class Main {
    
    // written own code here
    static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
    }
   

   public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();
      int k = sc.nextInt();
      
      // write your code here
      ArrayList<Edge>[] graph = new ArrayList[n];
      for(int i=0; i<n; i++){
          graph[i] = new ArrayList<>();
      }
      
      for(int i=0; i<k; i++){
          int a = sc.nextInt();
          int b = sc.nextInt();
          graph[b].add(new Edge(b,a));
          graph[a].add(new Edge(a,b));
      }
      
      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      boolean[] visited = new boolean[n];
      for(int i=0; i<visited.length; i++){
          if(visited[i]==false){
              ArrayList<Integer> comp = new ArrayList<>();
              gcc(graph, i, visited, comp);
              comps.add(comp);
          }
      }
      
      int ans = 0;
      for(int i=0; i<comps.size()-1; i++){
          for(int j=i+1; j<comps.size(); j++){
              ans += comps.get(i).size() * comps.get(j).size();
          }
      }
      
      System.out.println(ans);
   }
   
   // written own code here
   public static void gcc(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp){
       visited[src] = true;
       comp.add(src);
       for(Edge e: graph[src]){
           int nbr = e.nbr;
           if(visited[nbr]==false){
               gcc(graph, nbr, visited, comp);
           }
       }
   }

}
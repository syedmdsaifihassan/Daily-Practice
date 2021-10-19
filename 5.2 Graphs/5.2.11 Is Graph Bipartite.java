/*
Is Graph Bipartite
Easy
1. You are given a graph.
2. You are required to find and print if the graph is bipartite

Note -> A graph is called bipartite if it is possible to split it's vertices in two sets of mutually 
               exclusive and exhaustive vertices such that all edges are across sets.

Sample Input
7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10

Sample Output
false

Asked in Companies
Amazon      3
Walmart     2
Facebook        19
eBay        2

*/

import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   
   //written own code
   static class Pair {
      int vtx;
      int level;

      Pair(int vtx, int level){
         this.level = level;
         this.vtx = vtx;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      // write your code here
      
      boolean[] visited = new boolean[graph.length];
      for(int i=0; i<graph.length; i++){
          if(visited[i]==false){
              boolean isCompBip = isBipartite(graph, i, visited);
              if(isCompBip==false){
                  System.out.println(false);
                  return;
              }
          }
      }
      
      System.out.println(true);
   }
   
   
   //written own code
   public static boolean isBipartite(ArrayList<Edge>[] graph, int src, boolean[] visited){
       // to store info of old level
       HashMap<Integer, Integer> map = new HashMap<>();
       Queue<Pair> q = new ArrayDeque<>();
       q.add(new Pair(src, 0));
       
       while(q.size()!=0){
           Pair rp = q.remove();
           if(visited[rp.vtx]==true){
               // if already visited then cycle is present
               if(rp.level != map.get(rp.vtx)){
                   return false;
               }
           }else{
               visited[rp.vtx] = true;
               map.put(rp.vtx, rp.level);
               for(Edge e: graph[rp.vtx]){
                   int nbr = e.nbr;
                   if(visited[nbr]==false){
                       q.add(new Pair(nbr, rp.level+1));
                   }
               }
           }
       }
       
       return true;
   }
}
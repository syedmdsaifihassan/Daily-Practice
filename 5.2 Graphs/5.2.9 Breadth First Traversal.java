/*
Breadth First Traversal
Easy
1. You are given a graph, and a src vertex.
2. You are required to do a breadth first traversal and print which vertex is reached via which path, 
     starting from the src.

Note -> for output, check the sample output and question video.

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
2

Sample Output
2@2
1@21
3@23
0@210
4@234
5@2345
6@2346

*/

import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   
   //written own code Piar class
   static class Pair {
      String psf;
      int vtx;

      Pair(int vtx, String psf){
         this.psf = psf;
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());

      // write your code here
      Queue<Pair> q = new ArrayDeque<>();
      q.add(new Pair(src, src+""));
      
      bft(q, graph, new boolean[graph.length]);
   }
   
   //written own code
   public static void bft(Queue<Pair> q, ArrayList<Edge>[] graph, boolean[] visited){
       
       //remove
       //if already visited, do nothing
       //if not -> mark visited -> print -> add its unvisited neighbour
       while(q.size()!=0){
           Pair rp = q.remove();
           if(visited[rp.vtx]==false){
               visited[rp.vtx] = true;
               System.out.println(rp.vtx+"@"+rp.psf);
               for(Edge e: graph[rp.vtx]){
                   int nbr = e.nbr;
                   if(visited[nbr]==false){
                       q.add(new Pair(nbr, rp.psf+nbr));
                   }
               }
           }
       }
   }
}
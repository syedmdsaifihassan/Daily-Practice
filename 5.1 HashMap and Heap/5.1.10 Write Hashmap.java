/*
Write Hashmap
Easy

1. You are required to complete the code of our Hashmap class. Please watch the question video carefully. The theoretical details of required functionality is explained in detail there. Implement the functions to achieve what is explained in the theoretical discussion in question video.

Sample Input

put India 135
put Aus 5
put Canada 3
display
get China
remove Aus
get Aus
containsKey US
put US 10
put UK 20
remove US
containsKey US
put Pak 80
put China 200
display
put Utopia 0
display
put Nigeria 3
display
put India 138
display
put Sweden 1
display
put finland 20
display
quit

Sample Output

Display Begins
Bucket0 .
Bucket1 .
Bucket2 Canada@3 .
Bucket3 India@135 Aus@5 .
Display Ends
null
5
null
false
10
false
Display Begins
Bucket0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 Nigeria@3 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@138 China@200 Nigeria@3 .
Display Ends
Display Begins
Bucket0 Utopia@0 Sweden@1 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@138 China@200 Nigeria@3 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Pak@80 finland@20 .
Bucket3 .
Bucket4 Sweden@1 .
Bucket5 .
Bucket6 Canada@3 UK@20 .
Bucket7 India@138 China@200 Nigeria@3 .
Display Ends

*/

import java.io.*;
import java.util.*;

public class Main {

  public static class HashMap<K, V> {
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public HashMap() {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }

    public void put(K key, V value) {
      // write your code here
      int bi = hashFunction(key);
      int di = findWithinBucket(key, bi);
      if(di==-1){
          // key doesn't exist in map
          buckets[bi].add(new HMNode(key, value));
          size++;
      }else{
          buckets[bi].get(di).value = value;
      }
      
      double lambda = (double)size/(double)buckets.length;
      if(lambda>2.0){
          resize();
      }
    }
    
    public void resize(){
        LinkedList<HMNode>[] ob = buckets;
        buckets = new LinkedList[2*ob.length];
        for(int i=0; i<buckets.length; i++){
            buckets[i] = new LinkedList<>();
        }
        
        size = 0;
        for(int i=0; i<ob.length; i++){
            LinkedList<HMNode> ll = ob[i];
            for(int j=0; j<ll.size(); j++){
                put(ll.get(j).key, ll.get(j).value);
            }
        }
    }

    public V get(K key) {
        // write your code here
        int bi = hashFunction(key);
        int di = findWithinBucket(key, bi);
        
        if(di==-1){
            // key doesn't exist in map
            return null;
        }else{
            HMNode node = buckets[bi].get(di);
            return node.value;
        }
    }
    
    // return buckets index -> 0 to bucket.length-1
    public int hashFunction(K key){
        int hc = key.hashCode();
        return Math.abs(hc)%buckets.length;
    }
    
    // returns data index
    public int findWithinBucket(K key, int bi){
        for(int i=0; i<buckets[bi].size(); i++){
            if(buckets[bi].get(i).key.equals(key)){
                return i;
            }
        }
        return -1;
    }

    public boolean containsKey(K key) {
      // write your code here
      int bi = hashFunction(key);
      int di = findWithinBucket(key, bi);
      
      if(di==-1){
          // key doesn't exist in map
          return false;
      }else{
          return true;
      }
    }

    public V remove(K key) {
      // write your code here
        int bi = hashFunction(key);
        int di = findWithinBucket(key, bi);
        
        if(di==-1){
            // key doesn't exist in map
            return null;
        }else{
            // HMNode node = buckets[bi].remove(di);
            // size--; 
            // return node.value;
            V node = buckets[bi].get(di).value;
            buckets[bi].remove(di);
            size--;
            return node;
        }
    }

    public ArrayList<K> keyset() {
      // write your code here
      ArrayList<K> keys = new ArrayList<>();
      
      for(int i=0; i<buckets.length; i++){
          LinkedList<HMNode> ll = buckets[i];
          for(int j=0; j<ll.size(); j++){
              keys.add(ll.get(j).key);
          }
      }
      return keys;
    }

    public int size() {
      // write your code here
      return size;
    }

   public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
}

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}
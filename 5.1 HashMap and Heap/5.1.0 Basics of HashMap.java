import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 133);
        map.put("China", 160);
        map.put("USA", 90);
        map.put("India", 135);
        
        System.out.println(map.size());
        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println(map.containsKey("India"));
        System.out.println(map.get("India"));
        System.out.println(map.getOrDefault("Pakistan", 0));
        map.remove("USA");
        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println("-----------------");
        ArrayList<String> al = new ArrayList<>(map.keySet());
        for(int i=0; i<al.size(); i++){
            System.out.println(al.get(i));
        }
    }
}
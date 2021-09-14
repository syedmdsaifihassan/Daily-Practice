import java.util.*;
import java.io.*;

class Main {
    public static class Node{
        int data;
        ArrayList<Node> children;
        
        public Node(int data){
            this.data = data;
            children = new ArrayList<>();
        }
        
    }
    
    // root of generic tree
    public static Node construct(int[] arr){
        Node root = new Node(arr[0]);
        
        Stack<Node> st = new Stack<>();
        st.push(root);
        for(int i=1; i<arr.length; i++){
            if(arr[i]==-1){
                st.pop();
            }else{
                Node node = new Node(arr[i]);
                Node n = st.peek();
                n.children.add(node);
                st.push(node);
            }
        }
        return root;
    }
    
    public static void display(Node node){
        
        // node data
    	String str = node.data + "=>";
    	for (int i = 0; i < node.children.size(); i++) {
    		// add children data of current node.
    		str += node.children.get(i).data + ", ";
    	}
    	str += "END";
    	// Display the string for current node.
    	System.out.println(str);
    	
    	// display for all nodes(recursive)
    	for (int i = 0; i < node.children.size(); i++) {
    		display(node.children.get(i));
    	}
    }
    
    public static void main(String args[]) {
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = construct(arr);
        display(root);
    }
    
}
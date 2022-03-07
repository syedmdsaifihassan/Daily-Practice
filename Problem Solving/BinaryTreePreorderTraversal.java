/*
144. Binary Tree Preorder Traversal
Easy

Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,2,3]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

Follow up: Recursive solution is trivial, could you do it iteratively?

*/

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        //iterative
        // Stack<TreeNode> st = new Stack<TreeNode>();
        // List<Integer> ans = new ArrayList<>();
        // if(root==null)  return ans;
        // st.add(root);
        // while(!st.isEmpty()){
        //     TreeNode temp = st.pop();
        //     if(temp.right!=null)    st.add(temp.right);
        //     if(temp.left!=null)     st.add(temp.left);
        //     ans.add(temp.val);
        // }
        // return ans;
        
        //recursive
        List<Integer> ans = new ArrayList<>();
        if(root==null)  return ans;
        preOrder(root, ans);
        return ans;
    }
    //recursive
    public void preOrder(TreeNode root, List<Integer> ans){
        if(root==null)  return;
        
        ans.add(root.val);
        preOrder(root.left, ans);
        preOrder(root.right, ans);
    }
}
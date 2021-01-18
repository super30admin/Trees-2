Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
Iterative approach:
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        TreeNode node;
        int val;
        Pair(TreeNode node, int val){
            this.node=node;
            this.val=val;
        }
        public TreeNode getKey(){
            return this.node;
        } 
        public int getVal(){
            return this.val;
        }
    }
    public int sumNumbers(TreeNode root) {
        int result=0;
        int currSum=0;
        Stack<Pair> st = new Stack<>();
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                currSum = currSum*10 + root.val;
                st.push(new Pair(root, currSum));
                root=root.left;    
            }
            Pair p =st.pop();
            root=p.getKey();
            currSum=p.getVal();
            if(root.left==null && root.right==null){
                result+=currSum;
            }
            root=root.right;
            
        }
        
        return result;
    }
}

Recursive approach:
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        helper(root, 0);
        /*
        int result=0;
        int currSum=0;
        Stack<Pair> st = new Stack<>();
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                currSum = currSum*10 + root.val;
                st.push(new Pair(root, currSum));
                root=root.left;    
            }
            Pair p =st.pop();
            root=p.getKey();
            currSum=p.getVal();
            if(root.left==null && root.right==null){
                result+=currSum;
            }
            root=root.right;
        }
        */
        return result;
    }
    public void helper(TreeNode root, int currSum){
        if(root==null)return;
        currSum = currSum*10 + root.val;
        helper(root.left, currSum);
        if(root.left==null && root.right==null){
                result+=currSum;
        }
        helper(root.right, currSum);
    }
}
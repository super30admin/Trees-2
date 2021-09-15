/**
Running Time Complexity: O(n)
Space Complexity: Constant using Recursion 
successfully run and compiled on leetcode
/*
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
    int curr; int sum;
    public int sumNumbers(TreeNode root) {
        curr = 0; sum = 0;
        helper(root,curr);
        return sum;  
    }
    private void helper(TreeNode root,int curr){
        //base case
        if(root==null) return;
        if(root.left==null && root.right==null){
            sum += curr*10+root.val;
        }
        //logic
//         while(root!=null || !st.isEmpty()){
//             while(root!=null){
//                 curr = curr * 10 + root.val;
//                 st.push(new pair(root,curr));
//                 root = root.left;
//             }
        curr = curr*10+root.val;
        helper(root.left,curr);
        
//             pair p = st.pop();
//             root = p.getKey();
//             curr = p.getValue();
//             if(root.left==null && root.right==null){
//                 sum += curr ;
//             }
            
//             root = root.right;
            
//         }
        helper(root.right,curr);
    }
}
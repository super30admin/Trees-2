// Time Complexity : O(n) n is the number of nodes
// Space Complexity : O(h) h is the height of the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        int value;
        Pair(TreeNode node,int value){
            this.node = node;
            this.value = value;
        }
        
        public TreeNode getNode(){
            return this.node;
        }
        
        public int getSum(){
            return this.value;
        }
    }
    
    public int sumNumbers(TreeNode root) {
        
        if(root == null)    return 0;
        
        Stack<Pair> stack = new Stack();
        int result = 0;
        int curSum = 0;
        
        while(root != null || !stack.isEmpty()){
            
            while(root!=null){
                curSum = curSum*10 + root.val;
                stack.push(new Pair(root,curSum));
                root = root.left;
            }
            
            Pair p = stack.pop();
            TreeNode n = p.getNode();
            curSum = p.getSum();
            if(n.left == null && n.right == null){
                result += curSum;
            }
            root = n.right;
        }
        return result;
    }
}

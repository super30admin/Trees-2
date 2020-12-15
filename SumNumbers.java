// Time Complexity : O(N) N is number of nodes
// Space Complexity : O(h) h is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


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
    
    class Pair {
        
        TreeNode node;
        int value;
        
        public Pair(TreeNode node, int value) {
            this.node = node;
            this.value = value;
            
        }
        
        public TreeNode getKey() {
            return node;
        }
        
        public int getValue() {
            return value;
        }
        
        
    }
    public int sumNumbers(TreeNode root) {
        
        if(root == null) {
            return 0;
        }
        
        Stack<Pair> s = new Stack<>();
        int result = 0, curSum = 0;
        
        while(root != null || !s.isEmpty()) {
            
            while(root != null) {
                curSum = curSum * 10 + root.val;
                s.push(new Pair(root, curSum));
                root = root.left;
            }
            
            Pair p = s.pop();
            root = p.getKey();
            curSum = p.getValue();
            
            if(root.left == null && root.right == null) {
                result = result + curSum;
            }
            
            root = root.right;
            
        }
        
        return result;
        
    }
}
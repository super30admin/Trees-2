// Time Complexity : O(n)
// Space Complexity : O(h)
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
    
    // make Pair class to maintain node and num together
    class Pair{
        TreeNode node;
        int value;
    
        public Pair(TreeNode node, int value){
            this.node = node;
            this.value = value;
        }
        
        public TreeNode getNode(){
            return this.node;
        }
        
        public int getValue(){
            return this.value;
        }
        
    }
    
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        int currNum = 0;
        Stack<Pair> st = new Stack<>();
    
        while(root != null || !st.isEmpty()){
            while(root != null){
                currNum = currNum * 10 + root.val;
                Pair p = new Pair(root, currNum);
                st.push(p);
                root = root.left;
                
            }
            // st.pop();
            Pair p = st.pop();
            root = p.getNode();
            currNum = p.getValue();
            
            // process the node if it is leaf
            if( root.left == null && root.right == null){
                sum += currNum;
            }
            
            root = root.right;
        }
        return sum;
    }

}
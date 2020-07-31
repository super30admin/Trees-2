// There are two approaches
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

import java.util.Stack;
// Your code here along with comments explaining your approach
// Approach 1: Iterative
// Time Complexity : O(n)
//      n: number of nodes
// Space Complexity : O(h)
//      h: height of tree / depth of the tree

class Problem2S1 {

    /**Definition for a binary tree node.*/
    class TreeNode {

        // member variable
        int val;
        // referneces
        TreeNode left;
        TreeNode right;

        // default constructor
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**Definition for a Pair holds Node and Sum.*/
    class Pair{
        TreeNode node;
        int value;
        
        Pair(TreeNode node, int value){
            this.node = node;
            this.value = value;
        }
    }
    
    /** find sum from root to leaf node */
    public int sumNumbers(TreeNode root) {
        // global value
        int result = 0;
        if(root!=null){

            // stack
            Stack<Pair> myStack = new Stack<>();
            // local 
            int curSum=0;
            while(root!=null || !myStack.isEmpty()){
                
                // iterate left leaf
                while(root!=null){
                    // calculate value
                    curSum = curSum * 10 + root.val;
                    myStack.push(new Pair(root, curSum));
                    root = root.left;
                }
                // pop leaf
                Pair temp = myStack.pop();
                // update
                curSum = temp.value;
                root = temp.node;
                // if leaf node
                if(root.left==null && root.right==null)
                    result += curSum;
                // go right
                root = root.right;
            }
        }
        // resturn result
        return result;
        
    }
    
   
}
// Your code here along with comments explaining your approach
// Approach 2: Recursive
// Time Complexity : O(n)
//      n: number of nodes
// Space Complexity : O(h)
//      h: height of tree / depth of the tree
//      O(1): if we don't consider recursive space
class Problem2S2 {
    /**Definition for a binary tree node.*/
    class TreeNode {

        // member variable
        int val;
        // referneces
        TreeNode left;
        TreeNode right;

        // default constructor
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    // global result
    int result = 0;

    /** find sum from root to leaf */
    public int sumNumbers(TreeNode root) {
        if(root!=null)
            helper(root, 0);
    
        return result;   
    }
    
    /** helper function :DFS */
    private void helper(TreeNode root, int currentSum){
        // base case
        if(root==null)
            return;
        
        // previous number + current number
        currentSum*=10;
        currentSum += root.val;
        
        // leaf noode and to global result
        if(root.left==null && root.right==null){
            result += currentSum;
            return;
        }
        
        // go left
        helper(root.left, currentSum);
        // go right
        helper(root.right, currentSum);
            
    }
}
/**
## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
 
Time Complexity :   O (N) 
Space Complexity :  O (1) 
Did this code successfully run on Leetcode :    Yes (129. Sum Root to Leaf Numbers)
Any problem you faced while coding this :       No
 */

 // Input: root = [1,2,3]
 class SumNumbers {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }
    public void helper(TreeNode root, int currNum){
        // base case
        if(root==null)
            return;
        
        // calculate current sum for every node
        currNum = currNum*10 + root.val;
        // when leaf node, add currNum to result
        if(root.left == null && root.right == null){
            result += currNum;
        }
        // logic
        helper(root.left, currNum);
        helper(root.right, currNum);
    }
}
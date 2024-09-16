// Time Complexity : O(N) visiting all nodes
// Space Complexity : O(N) height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't solve before class


// Your code here along with comments explaining your approach


class Solution {
    
    Integer result;
    
    public int sumNumbers(TreeNode root) {
        
        result = 0;
        if(root == null){
            return 0;
        }
        
        calculateSumPath(root, 0);
        return result;
    }
    
    private void calculateSumPath(TreeNode node, int runningValue){
        //if leaf node present, add to result
        if(node.left == null && node.right == null){
            result += runningValue * 10 + node.val;
            return;
        }
        
        //calculate running value
        runningValue = runningValue * 10 + node.val;
        
        //repeat if left is not null
        if(node.left != null){
            calculateSumPath(node.left, runningValue);
        }
        
        //repeat if right is not null
        if(node.right != null){
            calculateSumPath(node.right, runningValue);
        }
    }
}
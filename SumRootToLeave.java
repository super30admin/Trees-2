// Time Complexity : O(n) n elements of the Tree
// Space Complexity : O(n) stack created
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Recursion
class Solution {
    int sum =0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);   
        return sum;
    }
    
    private void helper(TreeNode root, int currNumber){
        if(root != null){
            currNumber = currNumber * 10 + root.val;
            
            if(root.left==null && root.right==null){
                sum += currNumber; 
            }
            
            helper(root.left, currNumber);
            helper(root.right, currNumber);
        }
    }
}
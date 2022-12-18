// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : leaf node sum created problems


// Your code here along with comments explaining your approach
/*
we will solve it recursive , at each node we would multiply prev by 10 and add the current node sum, if leaf node we then add the current sum to total
else we will recurse
 */
class Solution {
    int totalSum =0;
    public int sumNumbers(TreeNode root) {
        helper(root,0); // previous sum as 0
        return totalSum;    
    }

    private void helper(TreeNode root , int prev){
        //base case
        if(root == null) return;
        int currentSum = prev * 10 + root.val; // running sum
        if(root.left == null && root.right == null) // if leaf node, then add to total
        totalSum+=currentSum;
        //else
        helper(root.left, currentSum); // recurse left
        helper(root.right,currentSum); // recurse right

    }


}
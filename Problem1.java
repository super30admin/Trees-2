// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * We maintain a currentSum which calculates the sum upto that point. 
 * We call the recursive function on the left child and right child until we reach null. 
 * If it reaches null, we return currSum. 
 * At the end we add the sum of left and right children to reach the total sum. 
 */

class Problem1 {
    public int sumNumbers(TreeNode root) {
        int sum = helper(root, 0);
        return sum;
    }
    private int helper(TreeNode root, int currSum){
        if(root == null) return 0;
        currSum = currSum * 10 + root.val; 
       int left = helper(root.left, currSum);
        int right = helper(root.right, currSum);
        if(root.left == null && root.right==null){
            return currSum;
        }
        return left+right;
    }
}
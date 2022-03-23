// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach

class SumToLeaf {
    public int sumNumbers(TreeNode root) {
        int ans =  helper(root , 0); 
        return ans;
    }
    public int helper(TreeNode root , int sum){
        if(root == null){
            return 0;
        }
        sum = sum*10 + root.val;
        if(root.right == null && root.left == null){
            return sum;
        }
        
        int finalSum = helper(root.left , sum ) + helper(root.right , sum);
        return finalSum;
    }
}
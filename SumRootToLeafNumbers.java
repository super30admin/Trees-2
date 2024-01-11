// Time Complexity :O(N)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this : Little bit about the logic


// Your code here along with comments explaining your approach :I use recursion here to find path from root to leaf
class Solution {
    public int sumNumbers(TreeNode root) {
        return RootToLeafNumbers(root, 0, 0);
    } 
    private int RootToLeafNumbers(TreeNode root, int currentSum, int sum){  
        if(root==null) return 0;

        currentSum= currentSum*10+root.val;

        if(root.left==null && root.right==null){
            sum= sum+currentSum;
            return sum;
        }
    return RootToLeafNumbers(root.left, currentSum, sum) + RootToLeafNumbers(root.right, currentSum, sum) ;    
    }
    
}
// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes.
// Any problem you faced while coding this :Nope.


// Your code here along with comments explaining your approach
class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root,0);
    }
    public int sum(TreeNode root, int sum){
        if(null == root){return 0;}	// base case
        sum = ((sum*10) + root.val);
        if(null == root.left && null == root.right){return sum;}
        return sum(root.left,sum) + sum(root.right,sum);
    }
}
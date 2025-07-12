// Time Complexity:O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    public int dfs(TreeNode root,int currentSum){
        if (root ==null){
            return 0;
        }
      
      currentSum  = currentSum * 10+root.val;

      if (root.left == null && root.right == null) {
            return currentSum;
        }

        return dfs(root.left,currentSum)+dfs(root.right,currentSum);
    }

}
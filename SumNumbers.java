/* Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number. 
* TC O(N) SC O(N)
* Code was submitted on leetcode
*/
class Solution {
    public int sumNumbers(TreeNode root) {
      if (root == null)
          return 0;
        return helper(root, 0, 0);
    }
    
    private int helper(TreeNode root, int currSum, int result) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            result = result + currSum * 10  + root.val;
        }
        return result + helper(root.left, currSum * 10  + root.val, result) + helper(root.right, currSum * 10  + root.val, result);
    }
}

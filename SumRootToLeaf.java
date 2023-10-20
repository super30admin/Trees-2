// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class SumRootToLeaf {
    class Solution {
        private int result;
        public int sumNumbers(TreeNode root) {
            helper(root, 0);
            return result;
        }

        private void helper(TreeNode root, int curSum){
            if(root == null) return;

            curSum = curSum * 10 + root.val;

            if(root.left == null && root.right == null){
                result += curSum;
            }

            helper(root.left, curSum);
            helper(root.right, curSum);
        }
    }
}

public class SumRootToLeaf {
    /**
     * Time Complexity - O(n)
     * Space Complexity - O(h) where h is the height the tree
     * Logic: traverse the tree recursively, have a running result variable that will keep a store of the current total result
     * for each recursive call pass a local variable current sum which will add the current sum * 10 + current root val
     * add the curr sum to the result if both the left and right child are null meaning leaf nodes. 
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        int result = 0;

        public int sumNumbers(TreeNode root) {
            helper(root, 0);
            return result;
        }

        private void helper(TreeNode root, int currSum) {
            // base case
            if (root == null) {
                return;
            }

            currSum = currSum * 10 + root.val;

            if (root.left == null && root.right == null) {
                result += currSum;
                return;
            }

            helper(root.left, currSum);
            helper(root.right, currSum);
        }
    }
}

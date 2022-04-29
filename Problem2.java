
class Problem2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
//    TC : O(n)
//    Sc : O(h) where h = height of tree

    class Solution {
        int tSum;

        public int sumNumbers(TreeNode root) {
            if (root == null) return 0;
            rootSum(root, 0);
            return tSum;
        }

        private void rootSum(TreeNode root, int currSum) {
            if (root == null) return;
            if (root.left == null && root.right == null) {
                tSum = tSum + currSum * 10 + root.val;
            }
            rootSum(root.left, currSum * 10 + root.val);
            rootSum(root.right, currSum * 10 + root.val);
        }
    }
}


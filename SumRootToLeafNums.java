/* TC: O (n) where n is the number of nodes in the tree
 * SC: O (h) where h is the height of the tree
 *
 * Approach: until you reach a leaf node, calculate currSum as currSum * 10 + root.val.
 * At a leaf, add the currSum to the total and return. Calculate for both left and right
 * subtrees.
 */
public class SumRootToLeafNums {
    // Definition for a binary tree node.
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

    int sum;
    public void sum(TreeNode root, int currSum) {
        if (root == null) return;
        // calculate current sum
        // note: no backtracking is required since currSum is a function param
        // and resets with each call
        currSum = currSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            // if leaf node, add to total and return
            sum += currSum;
            return;
        }
        // sum for left subtree
        sum(root.left, currSum);
        // sum for right subtree
        sum(root.right, currSum);
    }
    public int sumNumbers(TreeNode root) {
        sum(root, 0);
        return sum;
    }

}

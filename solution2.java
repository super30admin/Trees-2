/ Time complexity: O(N), where N is the number of nodes in the tree.
// Space complexity: O(d), where d is the depth of the tree.

class Solution2 {
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

    int sum = 0;
    public void helper(TreeNode root,  int val) {
        // base case 
        if (root.left == null && root.right == null) {
            // if leaf node add the val to sum
            sum += val;
            return;
        }
        // left tree
        if (root.left != null)
            helper(root.left, 10 * val + root.left.val);
        // right tree
        if(root.right != null) helper(root.right, 10*val+root.right.val);
    }    

    public int sumNumbers(TreeNode root) {
        if(root == null) return 0; 
        helper(root, root.val);
        return sum; 
    }
}
class TreeNode {
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


public class SumRootLeaf {

    // TC - O(n) n - number of nodes in a tree
    // SC - O(h) h - height of the tree
    int sum;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int currSum) {
        if(root == null) return;

        // 4 -> 9 -> 5 returns 495
        // Leaf node condition
        if(root.left == null && root.right == null) {
            sum += currSum * 10 + root.val;
        }

        // Going to the left sub-tree of the current root and calculate the sum
        helper(root.left, currSum * 10 + root.val);

        // Once we come out of the left sub-tree recursion, go to the right sub-tree and update the sum
        helper(root.right, currSum * 10 + root.val);
    }
}

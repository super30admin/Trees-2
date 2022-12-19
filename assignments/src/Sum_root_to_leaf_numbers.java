public class Sum_root_to_leaf_numbers {

    // Time: O(n), Space: O(h) where h = height of the tree
    int totSum = 0;
    public int sumNumbers(TreeNode root) {

        travel(root, 0);
        return totSum;
    }

    void travel(TreeNode root, int currNum) {
        if (root == null) return;

        currNum = currNum*10 + root.val;

        if (root.left == null && root.right == null) {
            totSum += currNum;
        }

        travel(root.left, currNum);
        travel(root.right, currNum);
    }
}

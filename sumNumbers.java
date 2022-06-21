// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class TreeNode {

    // class for constructing treeNode
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

class Main {

    // =================== IGNORE ========================

    private static TreeNode root;

    // to constructing binary Tree
    private static TreeNode addRecursive(TreeNode current, int val) {
        if (current == null) {
            return new TreeNode(val);
        }

        if (val < current.val) {
            current.left = addRecursive(current.left, val);
        } else if (val > current.val) {
            current.right = addRecursive(current.right, val);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public static void add(int val) {
        root = addRecursive(root, val);
    }

    // =================== IGNORE ========================
    // main function for code
    private static int result;

    public static int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }

    private static void helper(TreeNode root, int currSum) {
        // if root is null we return
        // base case
        if (root == null)
            return;

        // main logic
        helper(root.left, currSum * 10 + root.val);
        // if our node is leaf node we add it to the result
        if (root.left == null && root.right == null) {
            result += currSum * 10 + root.val;
        }
        helper(root.right, currSum * 10 + root.val);
    }

    public static void main(String[] args) {
        add(5);
        add(2);
        add(7);

        System.out.println(sumNumbers(root));
    }
}
// Time Complexity : O(n) n = number of nodes
// Space Complexity : O(h) h = height of tree (recursion stack)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// process in any order but make sure to send the correct value of current
// and then passing it on recursive calls. current * 10 + root.val
// Only return current when you are on a leaf node.

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

class RootToLeafSum {
    public int sumNumbers(TreeNode root) {
        return sumNumberRecursive(root, 0);
    }

    public int sumNumberRecursive(TreeNode root, int current) {
        if (root == null) {
            return 0;
        }

        current = current * 10 + root.val;
        // leaf node
        if (root.left == null && root.right == null) {
            return current;
        }

        return sumNumberRecursive(root.left, current) + sumNumberRecursive(root.right, current);
    }
}
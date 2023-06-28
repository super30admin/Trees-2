// Time Complexity : O(N)
// Space Complexity : O(H) where H is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// We do a depth-first traversal of the binary tree, where the currNum is updated at each step by concatenating the current node's value. When a leaf node is reached, the currNum represents the number formed by the path from the root to that leaf. The method recursively computes the sum of all such numbers across the tree.

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SumRootToLeaf {
    int Totalsum = 0;

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
        // return Totalsum;
    }

    private int helper(TreeNode root, int currNum) {
        if (root == null)
            return 0;

        currNum = currNum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return currNum;
        }
        // System.out.print("root: " + root.val);
        // System.out.println (" CurrNum: " +currNum +" ");

        // int left = helper(root.left, currNum);
        // int right = helper(root.right, currNum);
        // return left+right;

        return helper(root.left, currNum) + helper(root.right, currNum);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        SumRootToLeaf obj = new SumRootToLeaf();
        int sum = obj.sumNumbers(root);
        System.out.println("Sum of root-to-leaf numbers: " + sum);
    }
}

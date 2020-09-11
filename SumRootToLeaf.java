// Time Complexity :O(N) N= no of nodes in the tree
// Space Complexity :O(H) H= height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//1. We start traversing the tree from head to leaf and keep a track of the sum of each path.
//2 Adding up all the path would give us the desired result.
import java.util.*;

class SumRootToLeaf {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /// Using Recursion
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        return helper(root, 0);

    }

    int helper(TreeNode root, int sum) {
        if (root == null)
            return 0;

        if (root.left == null || root.right == null) {
            return sum * 10 + root.val;
        }

        int left = helper(root.left, sum * 10 + root.val);
        int right = helper(root.right, sum * 10 + root.val);
        return left + right;

    }

    // Using Iterative approach
    public static class Pair {
        TreeNode root;
        int sum;

        TreeNode getKey() {
            return this.root;
        }

        int getValue() {
            return this.sum;
        }

        public Pair(TreeNode root, int sum) {
            this.root = root;
            this.sum = sum;
        }

    }

    public int findSum(TreeNode root) {
        if (root == null)
            return 0;
        int sum = 0, result = 0;
        Stack<Pair> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                sum = sum * 10 + root.val;
                stack.push(new Pair(root, sum));
                root = root.left;
            }
            Pair p = stack.pop();
            root = p.getKey();
            sum = p.getValue();
            if (root.left == null && root.right == null) {
                result += sum;
            }
            root = root.right;

        }
        return result;
    }

    public static void main(String[] args) {
        SumRootToLeaf obj = new SumRootToLeaf();
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(0);
        tree.left.right = new TreeNode(5);
        tree.left.left = new TreeNode(1);

        System.out.println("Sum using recursion = " + obj.sumNumbers(tree));

        System.out.println("Sum using iteration = " + obj.findSum(tree));

    }
}
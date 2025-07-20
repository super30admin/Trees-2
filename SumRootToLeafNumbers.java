/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int total = 0; // when dfs() returning void


    public int sumNumbersIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();

        int totalSum = 0;
        int curSum = 0;

        while (root != null || !nodeStack.isEmpty()) {
            while(root != null) {
                nodeStack.push(root);
                curSum = curSum * 10 + root.val;
                sumStack.push(curSum);
                root = root.left;
            }

            root = nodeStack.pop();
            Integer popSum = sumStack.pop();

            if(root.left == null && root.right == null) {
                totalSum += popSum;
            }

            root = root.right;
            curSum = popSum;
        }
        return totalSum;
    }





    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        // we can also do sum * 10 + root.val this once and replcase in 3 places
        if (root.left == null && root.right == null) {
            sum = (sum * 10 + root.val);
            return sum;
        }


        return dfs(root.left, sum * 10 + root.val) + dfs(root.right, sum * 10 + root.val);
    }

    public int sumNumbersVoid(TreeNode root) {
        dfsVoid(root, 0);
        return total;
    }

    private void dfsVoid(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            total += (sum * 10 + root.val);
            return;
        }


        dfs(root.left, sum * 10 + root.val);
        dfs(root.right, sum * 10 + root.val);
    }
}
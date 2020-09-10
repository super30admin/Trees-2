/*
https://leetcode.com/problems/sum-root-to-leaf-numbers/
129. Sum Root to Leaf Numbers - MEDIUM

TC: O(n) - all nodes in the tree
SC: O(h) - height of tree
Approach: smallest valid input is null node, for which the sum is 0, and hence return 0
For every node, calculate the sum as the sum passed from parent * 10 + current node's value
Pass this value to the children.
If it reaches a node, for which left and right is null,
this is the leaf node and the function ends by returning the calculated sum.
*/
public class SumRootToLeafPath {
    class TreeNodeSum {
        TreeNode node;
        int sum;

        TreeNodeSum(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }

        int getSum() {
            return sum;
        }

        TreeNode getNode() {
            return node;
        }
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getSum(root, 0);
    }
    
    public static int getSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int currSum = sum*10 + root.val;
        
        if (root.left == null && root.right == null) {
            return currSum;
        }
        
        return getSum(root.left, currSum) + getSum(root.right, currSum);
    }
}

  
//https://leetcode.com/problems/sum-root-to-leaf-numbers/
// Time Complexity : O(n)
// Space Complexity : O(h), h -> height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class SumRootToLeaf {

    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public static int sum(TreeNode root, int currentSum) {
        if (root == null)
            return 0;

        currentSum = (currentSum * 10) + root.val;
        // System.out.println("currentSum is "+currentSum);

        if (root.left == null && root.right == null)
            return currentSum;

        int leftSum = sum(root.left, currentSum);
        int rightSum = sum(root.right, currentSum);

        return leftSum + rightSum;
    }

}
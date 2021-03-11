// Time Complexity : O(N) - Since we are traversing through all the elements.
// Space Complexity : O(N) - Height of the tree because of the recursion call stack.
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

public class SumRoot_129 {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, 0);
    }

    private int helper(TreeNode root, int currentSum) {
        if (root == null)
            return 0;
        currentSum = (currentSum * 10) + root.val; // In order to append the next element, if we can multiply with 10 it
                                                   // will append. - We can use string concat too. But this is clener
                                                   // approach.
        if (root.left == null && root.right == null) { // If we reached the leaf node return the sum.
            return currentSum;
        }
        int leftSum = helper(root.left, currentSum);
        int rightSum = helper(root.right, currentSum);
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        SumRoot_129 sumRoot_129 = new SumRoot_129();
        TreeNode tree = new TreeNode();
        TreeNode[] testList = new TreeNode[] { tree.getSample(), tree.getSampleTwo(), tree.getSampleThree() };
        for (TreeNode node : testList) {
            int sum = sumRoot_129.sumNumbers(node);
            System.out.println("The tree sum is " + sum);
        }
    }
}
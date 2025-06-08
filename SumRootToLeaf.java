/**
 * LeetCode 129. Sum Root to Leaf Numbers
 * Link: https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 */
// ------------------------- Solution 1 --------------------------------
public class SumRootToLeaf {
    /**
     * void based solution with global variable maintaining the final result and
     * local recursion parameter variable to hold the runningSum from top root till current node.
     * This is done with local recursion parameter as we need the original value of this variable
     * which goes inside the recursive stack, otherwise at a global level this variable would give
     * wrong answer as it always will give the last/latest value coming from previous recursive call
     *
     * Time: O(n) Auxiliary Space: O(1)
     * Recursion stack space: O(h) h -> height of tree, worst case O(n), complete BST O(log n)
     *
     * NOTE: calculation done at leaf node can be done at either preorder, inorder or postorder level
     * as no matter the order at which it gets processed, it will be leaf node at that time with
     * correct local variable sum value popped from the recursive call stack
     */
    int result;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int sum) {
        //base case
        if (root == null) {
            return;
        }

        //logic
        sum = sum*10 + root.val;

        //at leaf node add sum to result
        if (root.left == null && root.right == null) {
            result += sum;
        }

        helper(root.left, sum);
        helper(root.right, sum);
    }
}

// ------------------------- Solution 2 --------------------------------
class SumRootToLeaf2 {
    /**
     * int based solution where left side of sum and right side of sum are added recursively
     * eliminating the need of maintaining a dedicated global variable
     *
     * Time: O(n) Auxiliary Space: O(1)
     * Recursion stack space: O(h) h -> height of tree, worst case O(n), complete BST O(log n)
     */
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int sum) {
        //base case
        if (root == null) {
            return 0;
        }

        //logic
        //at leaf node add sum to result
        if (root.left == null && root.right == null) {
            return sum*10 + root.val;
        }

        return helper(root.left, sum*10 + root.val) + helper(root.right, sum*10 + root.val);
    }
}

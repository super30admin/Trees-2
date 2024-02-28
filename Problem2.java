// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

/**
 * We are starting from sum=0,
 * we make the curNum
 * we perform inorder traversal.
 * keep checking if the node is leaf. If leaf, add to the result sum
 */

public class Problem2 {
    int res;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int prevNum) {
        //base
        if(root == null) return;

        //logic
        int curNum = prevNum*10 + root.val;

        helper(root.left, curNum);

        if(root.left == null && root.right == null) {
            res += curNum;
            return;
        }

        helper(root.right, curNum);
    }

}

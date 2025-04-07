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
class SumToRoot {
    int sum;
    public int sumNumbers(TreeNode root) {
        this.sum = 0;
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int currNum){
            if(root == null)
                return;
            currNum = currNum*10 + root.val;
            if(root.left ==null && root.right == null)
                sum = sum + currNum;
            helper(root.left, currNum);
            helper(root.right, currNum);
    }
}
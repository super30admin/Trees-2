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
class Problem2 {
    int result;
    public int sumNumbers(TreeNode root) {
        this.result = 0;
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int currNum){
        // base case
        if(root == null) return;
     
        currNum = currNum * 10 + root.val;

        helper(root.right, currNum);

        if(root.left == null && root.right == null){
           result += currNum;
        }

        helper(root.left, currNum);
    }
}

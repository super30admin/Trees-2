/**
 * Time Complexity:  O(n)  where n is the number of nodes
 * Space Complexity: O(n) where h is the height of the tree
 */

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
    int totalSum;
    public int sumNumbers(TreeNode root) {
        totalSum = 0;
        dfs(root, 0);
        return totalSum;
    }

    void dfs(TreeNode node, int number){
        number =(int) 10 * number + node.val;
        if(node.left == null && node.right == null){
            totalSum+=number;
        }

        if(node.left !=null){
            dfs(node.left, number);
        }

        if(node.right !=null){
            dfs(node.right, number);
        }

    }
}
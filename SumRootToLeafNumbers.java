// Time Complexity : O(n), where n is the number of nodes
// Space Complexity : O(h), where h is the height of the binary tree
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

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
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        inorder(root, 0);
        return sum;
    }
    private void inorder(TreeNode root, int path){
        if(root == null){
            return;
        }
        path = (path * 10)+ root.val;
        inorder(root.left, path);
        //If leaf node
        System.out.println(root.val);
        System.out.println(path);
        System.out.println("-----");
        if(root.left == null && root.right == null){
            sum += path;
        }
        inorder(root.right, path);
    }
}
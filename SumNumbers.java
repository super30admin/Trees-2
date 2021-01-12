// Time Complexity : The time complexity is O(n) where n is the number of nodes.
// Space Complexity : The space complexity is O(h) where h is the height of the tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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

    int total;

    public int sumNumbers(TreeNode root) {

        if(root == null){
            return 0;
        }

        treePath(root,0);
        return total;

    }

    public void treePath(TreeNode root,int sum){

        sum = sum*10 + root.val;

        //base case if the leaf
        if(root.left == null && root.right == null){
            total += sum;
        }

        // Left traversal
        if(root.left != null){
            treePath(root.left,sum);
        }

        // Right traversal
        if(root.right != null){
            treePath(root.right,sum);
        }

    }
}
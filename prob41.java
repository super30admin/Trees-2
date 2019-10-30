//Space complexity-O[1]
//Time complexity-O[N]
//Ran successfully on leetcode
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null)
            return root.val;
        if (root.left != null){
            root.left.val=root.left.val + (root.val*10);
        }
        if (root.right != null){
            root.right.val=root.right.val + (root.val*10);
        }
        return sumNumbers(root.left) + sumNumbers(root.right);
    }
    }
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

 /* Time Complexity : O(n)
 * 	n - size of the tree */
/* Space Complexity : O(h) 
 * 	h - height of the tree */

 // retun type (int) based recursion

class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int currNum){
        if(root == null) return 0;
        //Number at node
        currNum = currNum * 10 + root.val;
        //check for leaf
        if(root.left == null && root.right == null){
            return currNum;
        }
        int left = helper(root.left, currNum);
        int right = helper(root.right, currNum);

        return left + right;
    }
}

// void based recursion

/*
class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int currNum){
        if(root == null) return;
        //Number at node
        currNum = currNum * 10 + root.val;
        //check for leaf
        if(root.left == null && root.right == null){
            result += currNum;
        }
        helper(root.left, currNum);
        helper(root.right, currNum);
    }
}
*/
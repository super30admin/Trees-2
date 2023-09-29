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

//SC: O(h) -> h = height of the tree
//TC: O(n)
class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int currNum) {
        //base
        if(root == null) return 0;
        //logic
        currNum = currNum*10 + root.val;
        if(root.left == null && root.right == null) return currNum;
        return helper(root.left, currNum) + helper(root.right, currNum);
    }

}

// class Solution {
//     int sum;
//     public int sumNumbers(TreeNode root) {
//         helper(root, 0);
//         return sum;
//     }

//     public void helper(TreeNode root, int currNum) {
//         //base
//         if(root == null) return;
//         if(root.left == null && root.right == null) {
//             sum += currNum*10+root.val;
//         }
//         //logic
//         currNum = currNum*10 + root.val;
//         // if(root.left == null && root.right == null) {
//         //     sum += currNum;
//         // }
//         helper(root.left, currNum);
//         helper(root.right, currNum);
//     }
// }
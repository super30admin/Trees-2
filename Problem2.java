import javax.swing.tree.TreeNode;

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
// class Solution {
//     int result;
//     public int sumNumbers(TreeNode root) {
//         return helper(root,0);
        
//     }

//     private int helper(TreeNode root, int curr){
//         //base case
//         if(root == null) return 0;

//         //logic
//         curr = curr * 10 + root.val;
//         if(root.left == null && root.right == null){
//             return curr;
//         }

//        int left = helper(root.left, curr);

//         int right = helper(root.right, curr);

//         return left + right;
//     }
// }


class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return result;
    }

    private void helper(TreeNode root, int curr){
        //base case
        if(root == null) return;

        //logic
        curr = curr * 10 + root.val;
        if(root.left == null && root.right == null){
            result += curr;
        }

        helper(root.left, curr);

        helper(root.right, curr);
    }
}
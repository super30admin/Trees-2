// TC - O(n), SC - O(1)


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
    // Declaring a global variable to count all path sums
    int total = 0;
    public int sumNumbers(TreeNode root) {
        // sanity check
        if(root == null){
            return 0;
        }
        // call helper method with root and 0(cursum is 0)
        helper(root, 0);
        return total;
        
    }
    
    private void helper(TreeNode node, int curSum){
        // If node left and node right is null, calculate cursum and add it to total
        if(node.left == null && node.right == null){
            total = total + (curSum * 10 + node.val);
        }
        
        // calculate cursum
        curSum = curSum*10 + node.val;
        // If nodes left is not null call helper method with node.left and cursum, same for node.right
        if(node.left != null){
            helper(node.left, curSum);    
        }
        if(node.right != null){
            helper(node.right, curSum);    
        }
    
    }
}


// class Solution {
//     int total = 0;
//     public int sumNumbers(TreeNode root) {
//         if(root == null){
//             return 0;
//         }
//         return helper(root, 0);
//     }
    
//     private int helper(TreeNode node, int curSum){
//         if(node.left == null && node.right == null){
//             total = total + (curSum * 10 + node.val);
//             return total;
//         }
//         curSum = curSum*10 + node.val;
//         if(node.left != null){
//             int leftSum = helper(node.left, curSum);    
//         }
//         if(node.right != null){
//             int rightSum = helper(node.right, curSum);    
//         }
//         return total;
//     }
// }
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
    // int sum;
//     public int sumNumbers(TreeNode root) {
//         if(root == null) sum=0;
//         else{
//             helper(root, 0);
//         }
//         return sum;
//     }
//     private void helper(TreeNode root, int currSum){
//         // base case
//         if(root == null) return;

    //         // logic
//         currSum = (currSum*10)+root.val;
//         if(root.left == null && root.right == null){
//             sum+=currSum;
//         }
//         helper(root.left, currSum);
//         helper(root.right, currSum);
//     }
    public int sumNumbers(TreeNode root){
        return helper(root, 0);
    }

    private int helper(TreeNode root, int currSum){
        //base case
        if(root == null) return 0;

        //Logic
        currSum = (currSum*10) + root.val;
        if(root.left == null && root.right == null){
            return currSum;
        }

        return helper(root.left, currSum) + helper(root.right, currSum);

    }
}
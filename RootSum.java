//TC = O(h), h = height of tree which is stack max
//SC = O(1)

//Using a global var to keep track of overall sum and a local var in the helper 
//method to keep track of the current numbers value post calculation. Use 
//recursion in the helper method to calculate the value of each node, and only
//adds the value to global sum if node is a leaf. 

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
    int sum;;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    public void helper(TreeNode root, int currNum){
        //base
        if(root==null) return;

        //logic
        currNum = currNum * 10 + root.val;

        if(root.left == null && root.right == null){
            sum += currNum;
            return;
        }

        helper(root.right, currNum);
        helper(root.left, currNum);
        

        return;
    }
}
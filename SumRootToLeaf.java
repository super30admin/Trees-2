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
 /**
This Java solution calculates the sum of all root-to-leaf paths in a binary tree:
Initialize a variable sum to store the result.
Use a recursive helper function (helper) to traverse the tree, updating the current path value (curr) by multiplying it by 10 and adding the current node's value.
If a leaf node is reached, add the current path value to the sum.
Return the final sum.
Time Complexity: O(N) - where N is the number of nodes in the binary tree, as each node is processed once.
Space Complexity: O(H) - where H is the height of the binary tree. The space used by the recursive call stack is proportional to the height of the tree. 
In the worst case, the height is O(N), making the space complexity O(N).
  */
  class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        
        helper(root, 0);
        return sum;
    }
    private void helper(TreeNode root, int curr){
        if(root == null) return;
        curr= curr*10 +root.val;
        if(root.left == null && root.right == null){
            sum += curr;
        }
        helper(root.left,curr);
        helper(root.right,curr);
    }
}
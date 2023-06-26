// Time Complexity : O(n)
// Space Complexity : O(n)
    // n is the number of nodes present in the tree.

// Your code here along with comments explaining your approach
    //We use a preorder traversal along with global variable "sum". We use a helper function with parameters the node and the current value.
    //Whenever we come to a node, we multiply the given parameter "current value" with "10" and add the node's value to the variable. 
    //We will then reucursively call the helper function for the node's children along with the updated parameter. When we come to a leaf node, we add the parameter "current value" to the sum.
    
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

    private int sum;

    public int sumNumbers(TreeNode root) 
    {
        sum = 0;
        open(root, 0);
        return sum;
    }

    private void open(TreeNode node, int currentValue)
    {
        if (node==null)
        {
            return;
        }
        currentValue *= 10;
        currentValue += node.val;
        if (node.left==null&&node.right==null)
        {
            sum += currentValue;
            return;
        }
        open(node.left, currentValue);
        open(node.right, currentValue);
    }
}
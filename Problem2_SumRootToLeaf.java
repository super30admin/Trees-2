/************ Time Complexity: O(h) *************/
/************ Space Complexity: O(1) *************/

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
        return iterativeSum(root, 0); //current sum = 0
    }
    
    public int iterativeSum(TreeNode node, int val){
        //base case
        if(node == null)
            return 0;
        
        //leaf node
        if(node.left == null && node.right==null) 
            return val*10 + node.val;
        //not a leaf node
        else
            //call iteravtively to left and right of the node and calculate the sum
            return iterativeSum(node.left, val*10 + node.val)+
                iterativeSum(node.right, val*10 + node.val);
    }
}
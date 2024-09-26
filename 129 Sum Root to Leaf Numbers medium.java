
//129. Sum Root to Leaf Numbers
//Time Complexity: O(n) 
//Space Complexity: O(n) worst case skewed binary tree
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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
     
        helper(root, 1, 0);
        return sum;
    }
    public void helper(TreeNode root, int tempSum,int flag){
        
            if(root == null){
                return;
            }
            if(flag == 0)
                tempSum = 0;
            else
                tempSum *= 10;
            tempSum += root.val;
            if(root.left == null && root.right == null){
                 sum += tempSum;
            }
          
            helper(root.left,tempSum,1);
            helper(root.right,tempSum,1);
              
    }
}
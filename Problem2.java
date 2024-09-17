// Time Compexity: O(n)
// Space Complexity: O(1)

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
    
    int globalSum = 0; // this is going to be the result
    
    public int sumNumbers(TreeNode root) {
        calcSum(root, 0);   
        
        return globalSum;
    }
    
    public void calcSum(TreeNode root, int localSum){
        if(root == null){
            return;
        }   
        
        if(root.left == null && root.right == null){
            localSum += root.val;
            globalSum += localSum;
            return;
        }
        
        int passSum = (localSum + root.val)*10;
        
        calcSum(root.left, passSum);
        calcSum(root.right, passSum);        
    }
}

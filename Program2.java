//Time Complexity : O(n)
//Space Complexity : O(h) for recursive stack

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
    int totalSum=0;
    public int sumNumbers(TreeNode root) {
        
       sumNumbers(root,0);
       return totalSum;
        
    }
    
    public void sumNumbers(TreeNode root, int sum){
        
        if(root==null){
            return;
        }
        sum=sum*10+root.val;
        if(root.left==null && root.right==null){
            totalSum+=sum;
        }
        sumNumbers(root.left,sum);
        sumNumbers(root.right, sum);
    }
    
    
    
}
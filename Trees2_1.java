//root to leaf
//time O(number of elements)
//space O(height of tree)
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
    int totalSum=0;

    public int sumNumbers(TreeNode root) {
        int csum=0;
        helper(root,csum);
        return totalSum;
    }

    public void helper(TreeNode node,int csum){
        // System.out.println("node val = "+node.val + " csum = "+csum + "totalsum= "+totalSum);

        if(node.left==null&&node.right==null){
            totalSum=totalSum+(csum*10)+node.val;
            return;
        }

        // System.out.println("node.val = "+node.val + "csum = "+csum + " totalsum currently = "+totalSum );
        if(node.left!=null){
            helper(node.left,(csum*10)+node.val);
        }
        if(node.right!=null){
            helper(node.right,(csum*10)+node.val);
        }



    }








}
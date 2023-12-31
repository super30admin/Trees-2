//Time Complexity:O(n)
//SpaceComplexity:O(h) , h =Binary tree height
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
    
    public int sumNumbers(TreeNode root) {
        return calcSumRoottoLeaf(root,0);
    }
    private int calcSumRoottoLeaf(TreeNode root, int currNum){
        if(root == null) return 0;
        

        currNum = currNum *10 + root.val;
        if(root.left == null && root.right == null)
            return currNum;
        int left = calcSumRoottoLeaf(root.left,  currNum);
        int right = calcSumRoottoLeaf(root.right,  currNum);
        return left+right;
    }
    
}
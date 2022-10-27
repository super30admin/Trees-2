// Approach: recursively calculate pathNum and return it to parent when you are at leaf. At each non-leaf node add left path sum and right path sum to get total and return that.
// Time Complexity : O(n) traversing all the numbers
// Space Complexity: O(h) height of the tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public int SumNumbers(TreeNode root) {
        return TraverseRec(root, 0);
    }
    
    public int TraverseRec(TreeNode node, int pathNum){
        if(node == null) return 0;
        
        pathNum = pathNum*10 + node.val;
        if(node.left == null && node.right == null){
            return pathNum;
        }
            
        var leftsum = TraverseRec(node.left, pathNum);
        var rightsum = TraverseRec(node.right, pathNum);
        
        return leftsum + rightsum ;
    }
}
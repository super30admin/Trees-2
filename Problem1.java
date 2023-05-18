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
//  Time: O(n)
// Space:O(h) height of the tree
class Solution {
    int sum;
    int cursum;
    public int sumNumbers(TreeNode root) {

        inorder(root,0);
         return sum;
    }

    public void inorder(TreeNode node, int cursum){
        //base
        if(node == null) return;
        //condition
        cursum = cursum*10+node.val;
        //below if can be rewritten as preorder, inorder or postorder
        if(node.left ==null && node.right == null){
            sum = sum + cursum;
        }
        inorder(node.left,cursum);

        inorder(node.right,cursum);
        

    }
}
//DFS
//T.C O(N)
//S.C O(h) where h=height of the tree.

**
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
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        helper(root,sum);
        return sum;
    }
    
    private void helper(TreeNode root,int currentSum){
        if(root==null){return;}
             if(root.left==null && root.right==null){
                 sum=sum+currentSum*10+root.val;
                 return;
             }
        helper(root.left,currentSum*10+root.val);
   helper(root.right,currentSum*10+root.val);
    }
}

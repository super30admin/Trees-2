// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class TreeNode {
        int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

public class build {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int posStart, int posEnd) {
        if(inStart > inEnd || posStart > posEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[posEnd]);
        int cnt = 0;
        for(int i = inStart; i <= inEnd && inorder[i] != root.val; i++) {
            cnt++;
        }
        root.left = helper(inorder, postorder, inStart, inStart+cnt-1, posStart, posStart+cnt-1);
        root.right = helper(inorder, postorder, inStart+cnt+1, inEnd, posStart+cnt, posEnd-1);
        return root;
    }
}
//Time - O(n)
//Space - O(n)

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
    HashMap<Integer,Integer> hm = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return helper(postorder.length-1,postorder,inorder,0,inorder.length);
    }

    public TreeNode helper(int idx, int[] postorder, int[] inorder, int si, int ei){
        if(idx<0 || si>=ei){
            return null;
        }
        TreeNode root = new TreeNode(postorder[idx]);
        int rootidx = hm.get(root.val);
        root.left = helper(idx-(ei-rootidx), postorder,inorder, si, rootidx);
        root.right= helper(idx-1,postorder,inorder,rootidx+1, ei ); 
        return root;
    }
}

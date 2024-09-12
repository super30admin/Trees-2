/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// time: O(n) n=numer of nodes
// space: O(n)
class Solution {
    int[] inorder;
    int[] postorder;
    HashMap<Integer,Integer> map=new HashMap<>();
    int post_indx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0 || postorder.length==0) return null;
        this.inorder=inorder;
        this.postorder=postorder;
        post_indx=postorder.length-1;
        int idx=0;
        for(int i: inorder)
        {
            map.put(i,idx++);
        }
        return helper(0,inorder.length-1);
    }
    // recursive function tp build tree
    private TreeNode helper(int left,int right)
    {
        if(left>right) return null;
        int val=postorder[post_indx];
      
        TreeNode root=new TreeNode(val);
        int index=map.get(val);
          post_indx--;
        
        root.right=helper(index+1,right);
        root.left=helper(left,index-1);
        return root;
    }
}
/**
 * Time Complexity : O(n) n-length of inorder or postorder arrays
 * Space Complexity: O(h) h-height of the tree which is being built
 *
 * Postorder - Left Right Root --hence in the gvn postorder array the root of the entire tree ll be at the end of the array
 * Inorder - Left Root Right
 */

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
    int index;
    HashMap<Integer,Integer> hmap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length-1;
        for(int i=0;i<inorder.length;i++)
            hmap.put(inorder[i],i);
        return helper(inorder,postorder,0,inorder.length-1);
    }
    public TreeNode helper(int[] in, int[] post, int st, int end){
        if(index < 0 || st > end || st<0 || end >= in.length) {
            //System.out.println(st+" "+end+" "+index);
            return null;
        }
        //System.out.println(st+" "+end+" "+index);
        int inindex = hmap.get(post[index]);
        TreeNode root = new TreeNode(post[index]);
        index--;
        root.right = helper(in,post,inindex+1,end);
        root.left = helper(in,post,st,inindex-1);
        return root;
    }
}
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

 // Time Complexity - O(N)
 // Space COmplexity - O(N)
class Solution {
    int idx;
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
                if(postorder == null || inorder == null || postorder.length != inorder.length){
            return null;
        }
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        idx = postorder.length-1;
        return buildFromPost(postorder,0,inorder.length-1);
    }
    
     public TreeNode buildFromPost(int[] postorder,int start, int end){
          if(start > end){
              return null;
          }
         TreeNode root = new TreeNode(postorder[idx]);
         idx--;
         int part = map.get(root.val);
         root.right = buildFromPost(postorder,part+1,end);
         root.left = buildFromPost(postorder,start,part-1);
         return root;
     }
}
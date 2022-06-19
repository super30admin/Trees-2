//Space O(n)
//Time O(n) where n is the number of elements in the binary tree

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
    HashMap<Integer, Integer> h = new HashMap<>();
   int curr;
   public TreeNode buildTree(int[] preorder, int[] inorder) {
       for(int i =0;i<inorder.length;i++)
           h.put(inorder[i],i);
       return helper(preorder,0,inorder.length-1);
       
   }
   private TreeNode helper(int[] pre,  int start, int end)
   {   if(start>end )
       return null;
       int currPreOrder=pre[curr];
       curr++;
       TreeNode root = new TreeNode(currPreOrder);
       int pos = h.get(currPreOrder);
        root.left= helper(pre, start,pos-1);
        root.right= helper(pre,  pos+1, end);
    return root;
       
       
       
   }
}
//Time Complexity- O(n)
//Space Complexity=O(n)
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
    HashMap<Integer,Integer>map=new HashMap();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder.length==0 || inorder==null ||
          postorder.length==0|| postorder==null)
        {
            return null;
        }
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return constructBinaryTree(inorder,postorder,0,inorder.length-1,postorder.length-1);        
    }
    TreeNode constructBinaryTree(int[] inorder,int[] postorder,int start,int end,int index)
    {
        if(start>end)
        {
            return null;
        }
        TreeNode root=new TreeNode(postorder[index]);
        int indexOfRoot=map.get(postorder[index]);
        root.left=constructBinaryTree(inorder,postorder,start,indexOfRoot-1,index-1-(end-indexOfRoot));
        root.right=constructBinaryTree(inorder,postorder,indexOfRoot+1,end,index-1);
        return root;
        
    }
}
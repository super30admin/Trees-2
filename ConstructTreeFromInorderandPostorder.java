import java.util.HashMap;

/**
 * Definition for a binary tree node.
 */


 /*Approach
 1) we use the same approach which we used from inorder and pre order traversal
 2) In preorder and inorder, we start index from start of preorder array, and in this we start from last element of postorder array
 3) coz we need to traverse left, right and root thus root value will be found as the last element.
 4) we recurse also from right and left to avoid the index from going to -1.
 5) recursion can be used through this way.
 */
 
 
class Solution {
    
    public class TreeNode {
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




    HashMap<Integer,Integer> map;
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder.length==0 || inorder==null)
        {
            return null;
        }
        
        map = new HashMap<>();
        index = postorder.length-1;
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        
        return helper(postorder,0,postorder.length-1);
        
        
    }
    
    public TreeNode helper(int [] postorder,int start, int end)
    {
        // base case
        if(start>end)
        {
            return null;
        }
        
        // logic
        
        int rootVal = postorder[index];
        index--;
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        
        // recursing through postorder
        root.right = helper(postorder,rootIndex+1,end);
        root.left= helper(postorder,start,rootIndex-1);
        
        return root;
        
        
        
    }
}
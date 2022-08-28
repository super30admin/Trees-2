// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, I was getting stack overflow error on line 48 
//which I could not figure out why

// Your code here along with comments explaining your approach:
//We are given postorder array which is left right root so pick the root element from the last index
//and recursively build the tree. Inorder array is being mapped to a HashMap so we do not require 
//it to be passed to helper function.

import java.util.HashMap;

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

public class ConstructBST {
    private static HashMap<Integer,Integer> map = new HashMap<>();
    private static int index;
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        index = inorder.length - 1;
        if(postorder.length == 0)
            return null;
        for(int i = 0;i < inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        
        return helper(postorder,0,inorder.length - 1);
    }
    
    private static TreeNode helper(int[] postorder,int start,int end)
    {        
        //base
        if(start > end) //this means that the start and end have crossed each other
            return null;
        
        int rootVal = postorder[index];
        index--;
        int rootIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.right = helper(postorder,rootIndex + 1,end);
        root.left = helper(postorder,start,rootIndex - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] postorder = new int[] { 9, 15, 7, 20, 3 };
        int[] inorder = new int[] { 9, 3, 15, 20, 7 };

        TreeNode result = buildTree(inorder, postorder);
        System.out.println(result.val);
        System.out.println(result.left.val);
        System.out.println(result.right.val);
    }
}

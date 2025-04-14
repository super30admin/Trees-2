// Time Complexity : O(n), where n is the number of nodes 
// Space Complexity : O(n),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

// Approach:
// Created a TreeNode class to define structure of binary tree nodes
// The insert method constructs the tree recursively from postorder[] using the index map of inorder[]
// The buildTree method initializes the hashmap from inorder[] and calls insert with postorder[] starting from the last index




import java.util.*;

public class InorderPostorder 
{
    int j=0;
    public class TreeNode 
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) 
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode insert(int[] postorder,HashMap<Integer,Integer> map,int l,int r)
    {
        TreeNode root = new TreeNode(postorder[j]);
        int x = map.get(postorder[j]);
        if(r>x  && j-1>=0)
        {
            j--;
            root.right = insert(postorder,map,x+1,r);
        }
        if(x>l && j-1>=0)
        {
            j--;
            root.left = insert(postorder,map,l,x-1);
        }
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        this.j= postorder.length-1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return insert(postorder,map,0,inorder.length-1);
    }
}


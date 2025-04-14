// Time Complexity : O(n), where n is the number of nodes 
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  -

// Approach:
// Defined a TreeNode class for binary tree structure
// preOrder recursively traverses the tree, forming numbers from root to leaf and storing them in ArrayList
// sumNumbers initializes ArrayList, calls traversal, and returns the total sum of all root-to-leaf numbers


import java.util.ArrayList;

public class sumRootToLeef 
{
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
    public void preOrder(TreeNode root,int s,ArrayList<Integer> al)
    {
        if(root.left==null && root.right==null)
        {   
            al.add((s*10+root.val));
        }
        if(root.left != null)
        {
            preOrder(root.left,(s*10+root.val),al);
        }
        if(root.right!=null)
        {
            preOrder(root.right,(s*10+root.val),al);
        }
    }
    public int sumNumbers(TreeNode root) 
    {
        ArrayList<Integer> al = new ArrayList<>();
        preOrder(root,0,al);
        int op = 0;
        for(int i=0;i<al.size();i++)
        {
            op = op+al.get(i);
        }
        return op;
    }
}

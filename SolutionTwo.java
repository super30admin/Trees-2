// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :nopes

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


    HashMap<Integer,Integer> map;
    int idx=0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(postorder.length==0||inorder.length==0)
            return null;

        map=new HashMap<>();

        idx= postorder.length-1;

        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }

        return helper(inorder,postorder,0,inorder.length-1);

    }

    public TreeNode helper(int[] inorder, int[] postorder,int start,int end)
    {
        if(start>end)
            return null;

        int rootVal = postorder[idx];

        int rootidx = map.get(rootVal);

        TreeNode root= new TreeNode(rootVal);

        idx--;

        root.right= helper(inorder,postorder,rootidx+1,end);

        root.left= helper(inorder,postorder,start,rootidx-1);

        return root;

    }
}
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
//T.C = O(N)
//T.c = O(n)
class Solution {
    int idx;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        idx = postorder.length-1;
        return helper(postorder, 0 , inorder.length-1);
        
    }
    
    private TreeNode helper(int[] postorder, int start, int end)
    {
        if(start>end)
        {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[idx]);
        int rootidx = map.get(postorder[idx]);
        idx--;
        
        root.right = helper(postorder,rootidx+1,end);
        root.left= helper ( postorder , start , rootidx-1);
        return root;
    }
        
    }

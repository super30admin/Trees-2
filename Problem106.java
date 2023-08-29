// Time Complexity : O(n) -->no.of nodes
// Space Complexity : O(n) --> hashmap space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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
    int idx;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         if(postorder.length == 0){
            return null;
        }
        this.map = new HashMap<>();
        this.idx= postorder.length-1;
        for(int i=0; i<inorder.length;i++)
        {
            map.put(inorder[i],i);
            
        }
       return helper(inorder, postorder, 0, inorder.length-1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int start, int end)
    {
        //base
        if(start>end) return null;

        //logic

        TreeNode root = new TreeNode(postorder[idx]);
        int rootIdx = map.get(root.val); // finding the index of root in inorder array
        idx--; // move to next element
         root.right =helper(inorder,postorder,rootIdx+1,end); // in postorder left of the root is right subtree
         root.left = helper(inorder,postorder,start,rootIdx-1);
       
       
       
        return root; 
    }
}
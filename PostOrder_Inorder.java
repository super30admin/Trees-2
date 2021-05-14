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
    //Time O(N)
    //Space O(N)
    HashMap<Integer, Integer> map;
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0)
        {
            return null;
        }
        map = new HashMap<>();
        index = postorder.length-1;
        for(int i=0 ; i<inorder.length ; i++)
        {
            map.put(inorder[i] , i);
        }
        return helper(postorder, 0 , postorder.length-1);
    }
    public TreeNode helper(int[] postorder, int start, int end)
    {
        if(start > end || index < 0)
        {
            return null;
        }
        int inIndex = map.get(postorder[index]);
        TreeNode root = new TreeNode(postorder[index]);
        index--;
        root.right = helper(postorder, inIndex+1, end);
        //In post order you will visit the root of the right subtree unlike the left subtree of preorder
        root.left = helper(postorder , start, inIndex-1);
        
        return root;
    }
}
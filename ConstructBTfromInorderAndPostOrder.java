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
//TC : O(N): N: length of inorder array
// SC:  O(N): O(2N) -> O(N) for recursive stack + O(N) for hashmap
// Did it run successfully on Leetcode? : Yes
class Solution {
    HashMap<Integer, Integer> map;
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      if ( inorder.length == 0 || postorder.length == 0)
        return null;
        index = postorder.length-1;
        map = new HashMap();
        for ( int i = 0; i < inorder.length; i++)
        {
             map.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] postorder, int start, int end)
    {
        //base
        if ( start > end)
            return null;
       
        //logic
        int rootVal = postorder[index];
        index--;
        int root_index = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.right = helper(postorder, root_index+1, end);
        root.left = helper(postorder, start, root_index -1 );
        return root;
    }
        
}

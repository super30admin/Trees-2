// Time Complexity : O(n)
// Space Complexity : O(n)

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
    int index;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.index = postorder.length-1;
        this.map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] postorder, int start, int end){
        //base 
        if(start > end)
            return null;
        //logic
        TreeNode root = new TreeNode(postorder[index]);
        int rootIndex = map.get(root.val);
        index--;
        root.right = helper(postorder, rootIndex+1, end);
        root.left = helper(postorder, start, rootIndex-1);
        return root;
    }
}
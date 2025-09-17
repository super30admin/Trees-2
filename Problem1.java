// 106. Construct Binary Tree from Inorder and Postorder Traversal

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
 

 /*
Ran on leetcode: Yes
TC: O(n) 
SC: O(n)
n is length of post order or inorder array
postorder array gives the root node values and use the inorder array is used to determnine which nodes should be on left and right of the root.
*/
class Solution {
    private int postOrderIdx;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postOrderIdx = postorder.length - 1;
        // Create hashmap for the inorder array for easier search
        this.inorderMap = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }

        return helper(postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int inorderStart, int inorderEnd){
        // return if the start and end in inorder cross each other
        if(inorderStart > inorderEnd){
            return null;
        }

        // get the root val from post order array
        int rootVal = postorder[postOrderIdx];
        TreeNode root = new TreeNode(rootVal);
        postOrderIdx--;

        //post order we build first right and then left
        //build right subtree
        root.right = helper(postorder, inorderMap.get(rootVal) + 1, inorderEnd);
        //build left subtree
        root.left = helper(postorder, inorderStart, inorderMap.get(rootVal) - 1);

        return root;
    }
}
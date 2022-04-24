/**
Problem: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
TC: O(n)
SC: O(n)
*/
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
    int postOrderIndex = 0;
    HashMap<Integer, Integer> inorderIndexMap = null;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIndex = postorder.length - 1;
        inorderIndexMap = new HashMap<>();
        
        for (int i = 0; i < inorder.length; ++i) {
            inorderIndexMap.put(inorder[i], i);
        }
        System.out.println(inorderIndexMap);
        
        return arrayToTree(postorder, 0, postorder.length - 1);
    }
    
    private TreeNode arrayToTree(int[] postorder, int left, int right) {
        if (left > right) return null;
        
        TreeNode root = new TreeNode(postorder[postOrderIndex]);
        --postOrderIndex;
        int index = inorderIndexMap.get(root.val);
        
        // Right first and then left. Order here matters because the next root is on the right half
        root.right = arrayToTree(postorder, index + 1, right);
        root.left = arrayToTree(postorder, left, index - 1);
        
        return root;
    }
}
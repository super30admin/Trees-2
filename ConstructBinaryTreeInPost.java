/**
 * Time complexity O(n)
 * space complexity O(n)
 */
import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        indexMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postorder.length-1, inorder, 0, postorder.length-1);
    }
    private TreeNode buildTree(int[] postorder, int poststart, int postend, int[] inorder, int instart, int inend) {
        if(poststart > postend) {
            return null;
        }
        int rootVal = postorder[postend];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = indexMap.get(rootVal);
        int leftTreeSize = rootIndex - instart;
        int rightTreeSize = inend - rootIndex;
        
        root.left = buildTree(postorder, poststart, poststart+leftTreeSize-1, inorder, instart, rootIndex-1);
        root.right = buildTree(postorder, poststart+leftTreeSize, postend-1, inorder, rootIndex+1, inend);
        return root;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
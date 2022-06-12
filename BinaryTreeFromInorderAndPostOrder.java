// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.HashMap;
public class BinaryTreeFromInorderAndPostOrder {
    class TreeNode {
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

    private HashMap<Integer, Integer> map;
    private int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length == 0) return null;
        map = new HashMap<>();
        index = postorder.length - 1;
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        TreeNode root = helper(postorder, 0, inorder.length);
        return root;
    }
    private TreeNode helper(int[] postorder, int start, int end){
        if(start >= end) return null;
        TreeNode root = new TreeNode(postorder[index]);
        int rootIdx = map.get(postorder[index]);
        index--;
        root.right = helper(postorder, rootIdx + 1, end);
        root.left = helper(postorder, start, rootIdx);
        return root;
    }
  
}

import java.util.HashMap;

import javax.swing.tree.TreeNode;

//Time Complexity: O(n)
//Space Complexity: O(n) , HashMap 
// Did the code run successfully on leetcode : yes 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    HashMap<Integer, Integer> map;
    int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        // base
        if (start > end) {
            return null;
        }

        // logic
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);

        root.left = helper(preorder, inorder, start, rootIdx - 1);
        root.right = helper(preorder, inorder, rootIdx + 1, end);

        return root;
    }

}

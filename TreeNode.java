import java.util.Map;
import java.util.HashMap;

/**
 * Definition for a binary tree node.
 */
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

// Time Complexity: O(n)
// Space Complexity: O(h)
// Did this code run on Leetcode successfully? : Yes
class Solution {
    private int postOrderIdx = 0;
    private Map<Integer, Integer> inorderMap;

    private TreeNode buildTreeHelper(int[] postorder, int left, int right) {
        // base case
        if(left > right) {
            return null;
        }

        int rootVal = postorder[postOrderIdx--];
        TreeNode root = new TreeNode(rootVal);

        root.right = buildTreeHelper(postorder, inorderMap.get(rootVal) + 1, right);
        root.left = buildTreeHelper(postorder, left, inorderMap.get(rootVal) - 1);

        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(
            inorder == null || 
            postorder == null || 
            inorder.length == 0 || 
            postorder.length == 0 || 
            inorder.length != postorder.length
        ) {
            return new TreeNode();
        }

        postOrderIdx = postorder.length - 1;
        inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(postorder, 0, postorder.length - 1);
    }
}
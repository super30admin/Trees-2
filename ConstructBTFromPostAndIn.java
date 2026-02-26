import java.util.*;

// Recursion, O(n) time, O(h) space
class Solution {
    private int postIndex;

    public TreeNode buildTree(int[] postorder, int[] inorder) {
        postIndex = postorder.length-1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(postorder, 0, inorder.length-1, map);
    }

    private TreeNode helper(int[] postorder, int start, int end, Map<Integer, Integer> map) {
        if (start > end) return null;

        TreeNode root = new TreeNode(postorder[postIndex]);
        postIndex--;

        int mid = map.get(root.val);
        
        root.right = helper(postorder, mid+1, end, map);
        root.left = helper(postorder, start, mid-1, map);

        return root;
    }
}


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
 
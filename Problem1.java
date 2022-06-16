// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//106. Construct Binary Tree from Inorder and Postorder Traversal
//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

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

class Problem1 {
    int preIndex = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        preIndex = inorder.length - 1;
        int inStrt = 0;
        int inEnd = inorder.length - 1;
        return build(inorder, postorder, inStrt, inEnd);
    }

    private TreeNode build(int[] inorder, int[] postorder, int inStrt, int inEnd) {

        if (inStrt > inEnd)
            return null;

        TreeNode tNode = new TreeNode(postorder[preIndex--]);

        if (inStrt == inEnd)
            return tNode;

        int inIndex = search(inorder, inStrt, inEnd, tNode.val);

        tNode.right = build(inorder, postorder, inIndex + 1, inEnd);
        tNode.left = build(inorder, postorder, inStrt, inIndex - 1);

        return tNode;
    }

    private int search(int arr[], int strt, int end, int value) {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return i;
    }
}
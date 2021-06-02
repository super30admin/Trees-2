package Tree1;

import java.util.HashMap;

/* S30 Big N Problem #45 {Medium} - https://www.youtube.com/watch?v=ZfYtnUTI7WE
    Given inorder and postorder traversal of a tree, construct the binary tree.
    Note:
    You may assume that duplicates do not exist in the tree.

    For example, given
    inorder = [9,3,15,20,7]
    postorder = [9,15,7,20,3]
    Return the following binary tree:

       3
       / \
      9  20
        /  \
       15   7
    Source Link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
    -------------------------------------------------------------------------------------------------------
    Time complexity : o(n) - n is the number of elements in tree
    space complexity: o(h) - since we are maintaining the same element list with backtracking
    Did this code run successfully in leetcode : yes
    problems faces : no*/

public class ConstructBTInorderPostOrder {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int idx = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (postorder == null || postorder.length == 0)
            return null;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        idx = inorder.length-1;

        return helper(postorder, inorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int[] inorder, int start, int end) {

        if (start > end)
            return null;

        int rootIdx = map.get(postorder[idx]);
        TreeNode root = new TreeNode(postorder[idx]);

        idx--;

        
        root.right = helper(postorder, inorder, rootIdx + 1, end);
        root.left = helper(postorder, inorder, start, rootIdx - 1);

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

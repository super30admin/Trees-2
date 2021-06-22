package Trees2;

import java.util.HashMap;

/*  Time complexity : o(n) - n is the number of elements in tree
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

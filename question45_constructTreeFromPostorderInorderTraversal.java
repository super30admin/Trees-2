package Trees2;

import java.util.HashMap;
import java.util.Stack;

public class question45_constructTreeFromPostorderInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val)
        {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
        We will first put the elements from the inorder traversal in the HashMap so there is no need
        to find the root.
     */

    /*
        Time Complexity: O(N)
        Space Complexity: O(N)
    */
    HashMap<Integer, Integer> map = new HashMap<>();
    int postIndex = 0;
    int[] postorder;
    int[] inorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        int index = 0;
        postIndex = postorder.length - 1;
        for(Integer i: inorder) {
            map.put(i, index++);
        }
        return helper(0, inorder.length - 1);
    }
    private TreeNode helper(int start, int end) {
        if(start > end) return null;

        int rootVal = postorder[postIndex];
        TreeNode root = new TreeNode(rootVal);

        int index = map.get(rootVal);
        postIndex--;
        root.right = helper(index + 1, end);
        root.left = helper(start, index - 1);
        return root;
    }

    public static void main(String[] args) {

    }
}

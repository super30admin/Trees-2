
// Time complexity : O(n)
// Space complexity : O(n)
import java.util.*;

class TreeNode {
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

public class ConstructTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        int[] postorder = { 9, 15, 7, 20, 3 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        buildTree(inorder, postorder);
    }

    private static int postIndex = 0;
    static Map<Integer, Integer> map;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int start = 0;
        int end = postorder.length - 1;
        postIndex = postorder.length - 1;
        map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return constructTree(inorder, postorder, start, end);
    }

    private static TreeNode constructTree(int[] inorder, int[] postorder, int start, int end) {
        if (start > end)
            return null;
        int rootValue = postorder[postIndex--];
        TreeNode root = new TreeNode(rootValue);
        int index = map.get(rootValue);
        root.right = constructTree(inorder, postorder, index + 1, end);
        root.left = constructTree(inorder, postorder, start, index - 1);
        return root;
    }

}
//Time Complexity: O(n)
//Space Complexity: O(n)
// Did this code successfully run on Leetcode :Yes
//Approach: The idea is to use inorder for fetching the indices of the parent and the child
//Postorder is used for fetching the rootVal, once you do that, find the index of the root in the inorder array
//to the left of the root index exists the left subtree, to the right exists the right subtree
//and then the problem repeats for both the left and right subtrees
//The root val will be found at the last index of the postorder, we are performing recursion from the back to front
import java.util.HashMap;
import java.util.Map;

public class BinaryTreeInorderPostOrder {

    private Map<Integer, Integer> indices;
    private int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.index = postorder.length - 1;
        this.indices = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) indices.put(inorder[i], i);
        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int start, int end) {
        if (start > end) return null;

        int rootVal = postorder[index--];
        int rootIdx = indices.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        root.right = helper(postorder, rootIdx + 1, end);
        root.left = helper(postorder, start, rootIdx - 1);

        return root;
    }

    public static void main(String[] args) {
        final BinaryTreeInorderPostOrder binaryTreePreorderInorder = new BinaryTreeInorderPostOrder();
        final TreeNode root = binaryTreePreorderInorder.buildTree(new int[] {3,9,20,15,7}, new int[] {9,15,7,20,3});

        assert root.val == 3;
        assert root.left.val == 9;
        assert root.left.left == null;
        assert root.left.right == null;
        assert root.right.right.val == 20;
        assert root.right.right.left.val == 15;
        assert root.right.right.right.val == 7;
    }
}

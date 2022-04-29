import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    // Definition for a binary tree node.
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
//recursion solution
//    TC : O(n^2)
//    Sc : O(n^2)

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0
                || postorder.length == 0) return null;
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int[] inOrderLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inOrderRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] postOrderLeft = Arrays.copyOfRange(postorder, 0, index);
        int[] postOrderRight = Arrays.copyOfRange(postorder, index, postorder.length - 1);
        root.left = buildTree(inOrderLeft, postOrderLeft);
        root.right = buildTree(inOrderRight, postOrderRight);
        return root;
    }

    //    TC : O(n)
//    Sc : O(n)

    Map<Integer, Integer> map;
    int idx;

    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0
                || postorder.length == 0) return null;
        map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        idx = postorder.length - 1;
        return helper(postorder, 0, postorder.length - 1);

    }

    private TreeNode helper(int[] postorder, int start, int end) {
        //base case
        if (start > end || idx < 0) return null;

        //logic
        int rootVal = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);

        root.right = helper(postorder, rootIdx + 1, end);
        root.left = helper(postorder, start, rootIdx - 1);

        return root;
    }

    public static void main(String[] args) {
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        int[] postOrder = new int[]{9, 15, 7, 20, 3};
        Problem1 problem1 = new Problem1();
        TreeNode result = problem1.buildTree1(inOrder, postOrder);
        System.out.println("Final value" + result);
    }
}

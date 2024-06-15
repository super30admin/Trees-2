//time complexity:O(n)
//space complexity:O(h)
import java.util.*;

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

public class TreePostIn {
    Map<Integer, Integer> inMap;
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        idx = postorder.length - 1;
        return recurse(postorder, 0, inorder.length - 1);
    }

    public TreeNode recurse(int[] postorder, int start, int end) {
        if (start > end || idx < 0) {
            return null;
        }
        int rootVal = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = inMap.get(rootVal);
        root.right = recurse(postorder, rootIdx + 1, end);
        root.left = recurse(postorder, start, rootIdx - 1);
        return root;
    }

    public void printPreorder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public static void main(String[] args) {
        int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder = {9, 3, 15, 20, 7};
        TreePostIn tree = new TreePostIn();
        TreeNode root = tree.buildTree(inorder, postorder);
        tree.printPreorder(root);  // Expected output: 3 9 20 15 7
    }
}

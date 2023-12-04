// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

//as postrder follows left->right->root insert all inorder elements in map. and iterate over postorder from last as one element as root
//and find the index position in map and pass the left tree boundries values and right tree boundries recusrsivly.  
import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Problem1 {
    HashMap<Integer, Integer> map;
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        idx = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(postorder, 0, idx, 0);
    }

    private TreeNode helper(int[] postorder, int start, int end, int ridx) {
        if (start > end) {
            return null;
        }

        int rootValue = postorder[idx];
        idx--;

        ridx = map.get(rootValue);

        TreeNode root = new TreeNode(rootValue);

        root.right = helper(postorder, ridx + 1, end, ridx);
        root.left = helper(postorder, start, ridx - 1, ridx);

        return root;
    }

    private void printInorder(TreeNode node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        Problem1 treeBuilder = new Problem1();

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = treeBuilder.buildTree(inorder, postorder);

        treeBuilder.printInorder(root);
    }
}

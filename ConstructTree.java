import java.util.HashMap;
import java.util.Map;

// TC O(N)
// SC O(N)
public class ConstructTree {

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

    Map<Integer, Integer> map = new HashMap<>();
    int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null) {
            return null;
        }
        index = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int rootVal = postorder[index];
        TreeNode root = new TreeNode(rootVal);
        index--;
        int idx = map.get(rootVal);
        root.right = helper(postorder, idx + 1, end);
        root.left = helper(postorder, start, idx - 1);
        return root;
    }
}

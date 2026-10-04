//Time Complexity: O(n)
//Space Complexity: O(n)

import java.util.HashMap;
import java.util.Map;
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

public class ConstructBinaryTree {
    int idx;
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length - 1;
        this.map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int st, int end) {
        if (st > end)
            return null;
        int rootVal = postorder[idx];
        int rootIdx = map.get(rootVal);
        idx--;

        TreeNode root = new TreeNode(rootVal);

        root.right = helper(postorder, rootIdx + 1, end);
        root.left = helper(postorder, st, rootIdx - 1);

        return root;

    }
}

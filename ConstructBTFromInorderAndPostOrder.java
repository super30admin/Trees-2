
/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromInorderAndPostOrder {

  int index;
  Map<Integer, Integer> map;

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
      return null;
    }

    map = new HashMap<Integer, Integer>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    index = postorder.length - 1;
    return createTree(postorder, 0, index);
  }

  public TreeNode createTree(int[] postorder, int start, int end) {
    if (start > end) {
      return null;
    }
    int rootValue = postorder[index];
    TreeNode root = new TreeNode(rootValue);
    int rootIndex = map.get(rootValue);
    index--;

    root.right = createTree(postorder, rootIndex + 1, end);
    root.left = createTree(postorder, start, rootIndex - 1);
    return root;
  }

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
}

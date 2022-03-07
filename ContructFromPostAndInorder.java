
public class ConstructBSTFromPostAndInOrder {
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

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    return helper(0, postorder.length - 1, 0, inorder.length - 1, postorder, inorder);
  }

  public TreeNode helper(int postStart, int postEnd, int inStart, int inEnd, int[] postorder, int[] inorder) {
    if (inStart > inEnd || postEnd >= postorder.length || postEnd < 0) {
      return null;
    }

    TreeNode root = new TreeNode(postorder[postEnd]);

    int inIndex = 0;
    for (int i = inStart; i <= inEnd; i++) {
      if (inorder[i] == root.val) {
        inIndex = i;
      }
    }

    root.left = helper(postStart, postStart + inIndex - inStart - 1, inStart, inIndex - 1, postorder, inorder);
    root.right = helper(postEnd - inEnd + inIndex, postEnd - 1, inIndex + 1, inEnd, postorder, inorder);

    return root;
  }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Last node in postorder is the root. We make this the root node
// and then find this in the postorder. The left of this node gives us left subtree
// and the right side the right subtree. We then recursively set the root.left
// by dividing our postorder until the left of found index and root.right from the
// index towards the right.


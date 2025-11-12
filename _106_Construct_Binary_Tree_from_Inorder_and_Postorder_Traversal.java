/**** Method 1 ****/
//Time Complexity: O(n^2)
//Space Complexity: O(n^2)

//Successfully submitted in LeetCode

//The root is always the last element in postorder, so we find the it's index in inorder, so that we can partition array into left and right as all the elements present before the root in inorder are left and after are right, so we build a TreeNode with root and then assign node.left with both left parts of arrays and node.right with right arrays.

/**** Method 2 ****/
//Time Complexity: O(n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

// Rather than slicing the array, we can use indexs and a map with values and index of inorder array to reduce lookup time.

import java.util.Arrays;
import java.util.HashMap;

public class _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

  /**** Method 1 ****/
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (postorder == null || postorder.length == 0 || inorder.length == 0) {
      return null;
    }

    int val = postorder[postorder.length - 1];

    TreeNode root = new TreeNode(val);
    int idx = 0;

    for (int i = 0; i < inorder.length; i++) {
      if (val == inorder[i]) {
        idx = i;
        break;
      }
    }

    int postorderLeft[] = Arrays.copyOfRange(postorder, 0, idx);
    int postorderRight[] = Arrays.copyOfRange(
      postorder,
      idx,
      postorder.length - 1
    );
    int inorderLeft[] = Arrays.copyOfRange(inorder, 0, idx);
    int inorderRight[] = Arrays.copyOfRange(inorder, idx + 1, inorder.length);

    root.left = buildTree(inorderLeft, postorderLeft);
    root.right = buildTree(inorderRight, postorderRight);

    return root;
  }

  /**** Method 2 ****/
  public TreeNode buildTree1(int[] postorder, int[] inorder) {
    if (postorder == null || postorder.length == 0 || inorder.length == 0) {
      return null;
    }

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }

    return helper(
      postorder,
      0,
      postorder.length - 1,
      inorder,
      0,
      inorder.length - 1,
      map
    );
  }

  private TreeNode helper(
    int[] postorder,
    int postStart,
    int postEnd,
    int[] inorder,
    int inStart,
    int inEnd,
    HashMap<Integer, Integer> map
  ) {
    if (postStart > postEnd || inStart > inEnd) return null;

    int val = postorder[postEnd];

    TreeNode root = new TreeNode(val);
    int idx = map.get(val);
    int leftSize = idx - inStart;

    root.left = helper(
      postorder,
      postStart,
      postStart + leftSize - 1,
      inorder,
      inStart,
      idx - 1,
      map
    );
    root.right = helper(
      postorder,
      postStart + leftSize,
      postEnd - 1,
      inorder,
      idx + 1,
      inEnd,
      map
    );

    return root;
  }
}

class Solution {
  int postIndex;
  int[] postorder;
  int[] inorder;
  HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

  public TreeNode binaryTree(int in_left, int in_right) {
    if (in_left > in_right)
      return null;

    int root_val = postorder[postIndex];
    TreeNode root = new TreeNode(root_val);
    int index = idx_map.get(root_val);
    postIndex--;
    root.right = binaryTree(index + 1, in_right);
    root.left = binaryTree(in_left, index - 1);
    return root;
  }

 public TreeNode buildTree(int[] inorder, int[] postorder) {
    this.postorder = postorder;
    this.inorder = inorder;
    postIndex = postorder.length - 1;
    int idx = 0;
    for (Integer val : inorder)
      idx_map.put(val, idx++);
    return binaryTree(0, inorder.length - 1);
  }
}
//Time Complexity- O(n)
//Space Complexity - O(n)
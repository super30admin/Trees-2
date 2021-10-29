import java.util.Arrays;
import java.util.HashMap;
// TC - O(N) - each node
// SC - O(N) - Entire tree

public class Problem1 {

    int postIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public static class TreeNode {
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

  public TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd) {
      if(inStart > inEnd) return null;

      TreeNode root = new TreeNode(postorder[postIndex]);

      --postIndex;

      int index = map.get(root.val);

      root.right = helper(inorder, postorder, index + 1, inEnd);
      root.left = helper(inorder, postorder, inStart, index - 1);

      return root;
  }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        postIndex = postorder.length - 1;

        return helper(inorder, postorder, 0, inorder.length - 1);
    }

    public static void main(String[] args) {

    }

}

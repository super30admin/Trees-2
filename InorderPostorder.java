import java.util.Arrays;
//tc : O(n); n = len of arrays
//sc : O(n); bcz of recursion stack
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
public class InorderPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) return null;
        int n = postorder.length;
        TreeNode root = new TreeNode(postorder[n - 1]);
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }

        int inLeft[] = Arrays.copyOfRange(inorder, 0, index);
        int inRight[] = Arrays.copyOfRange(inorder, index+1, n);

        int postLeft[] = Arrays.copyOfRange(postorder, 0, index);
        int postRight[] = Arrays.copyOfRange(postorder, index, n - 1);

        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);

        return root;
    }
}

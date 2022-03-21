// Time Complexity:           O(n)
// Space Complexity:          O(n+h)
// where n is number of nodes in tree, h is height of the tree
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 */
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

class PostInToBinaryTree {
    int postIndex;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length-1;
        for(int i =0; i<inorder.length; i++)
            map.put(inorder[i],i);
        int postIndex = postorder.length-1;
        return build(postorder, 0, inorder.length-1);
    }
    private TreeNode build(int[] postorder, int start, int end) {
        if(start > end)
            return null;
        TreeNode root = new TreeNode(postorder[postIndex--]);
        if(root == null)
            return null;
        if(start == end)
            return root;

        int index = map.get(root.val);

        root.right = build(postorder, index+1, end);
        root.left = build(postorder, start, index-1);

        return root;
    }
}
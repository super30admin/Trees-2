// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
public class InorderPostorderTraversal {
   int index;
   public TreeNode buildTree(int[] inorder, int[] postorder) {
     Map<Integer, Integer> map = new HashMap<>();
     for (int i = 0; i < inorder.length; i++) {
       map.put(inorder[i], i);
     }
     index = postorder.length - 1;
     return helper(inorder, postorder, 0, postorder.length - 1, map);
   }
   
   private TreeNode helper(int[] inorder, int[] postorder, int start, int end, Map<Integer, Integer> map) {
     if (start > end) {
       return null;
     }
     TreeNode node = new TreeNode(postorder[index]);
     int pos = map.get(postorder[index--]);
     node.right = helper(inorder, postorder, pos + 1, end, map);
     node.left = helper(inorder, postorder, start, pos - 1, map);
     return node;
   }
}

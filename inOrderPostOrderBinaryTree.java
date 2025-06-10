//global index tracks the current root from postorder, and a map finds the root’s position in inorder. The tree is built recursively by constructing the right subtree first, then the left, since postorder is processed from the end.
 //Time Complexity: O(n)
 //Space complexity: O(n)
class Solution {
    Map<Integer, Integer> map = new HashMap();

  int index = 0;

  public TreeNode buildTree(int[] inorder, int[] postorder) {

      if(inorder.length == 0 || postorder.length == 0){

          return null;

      }

      index = postorder.length - 1;

      for(int i=0; i<inorder.length; i++){

          map.put(inorder[i], i);

      }

      return helper(inorder, postorder, 0, inorder.length-1);

  }

  private TreeNode helper(int[] inorder, int[] postorder, int start, int end){

      if(index < 0 || start > end){

          return null;

      }

      int inorderIndex = map.get(postorder[index--]);

      TreeNode root = new TreeNode(inorder[inorderIndex]);

      if(start == end){

          return root;

      }

      root.right = helper(inorder, postorder, inorderIndex+1, end);

      root.left = helper(inorder, postorder, start, inorderIndex-1);

      return root;
    }
}
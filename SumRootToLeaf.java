// O(n) time || O(h) space  - where h is the height of the tree
class Solution {
  int rootToLeaf = 0;

  public void preorder(TreeNode r, int currNumber) {
    if (r != null) {
      currNumber = currNumber * 10 + r.val;
      // if it's a leaf, update root-to-leaf sum
      if (r.left == null && r.right == null) {
        rootToLeaf += currNumber;
      }
      preorder(r.left, currNumber);
      preorder(r.right, currNumber) ;
    }
  }

  public int sumNumbers(TreeNode root) {
    preorder(root, 0);
    return rootToLeaf;
  }
}


/*
Time Complexity:  O(n)
Space Complexity: O(1)
 */

public class sumRootToLeaf {
  int result =0;
  public int sumNumbers(TreeNode root) {

    helper(root,0);
    return result;
  }

  private void helper(TreeNode root, int n){
    if(root== null) return;
    int currentVal = n*10 + root.val;

    if(root.left == null && root.right == null){
      result= currentVal + result;
      return;
    }

    helper(root.left, currentVal);
    helper(root.right,currentVal);

  }
}


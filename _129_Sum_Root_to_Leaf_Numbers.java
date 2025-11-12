/**** Method 1 ****/
//Time Complexity: O(n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode
//We can use a two variable to store sum(local) and ans(global), at each step we add sum*10 plus root.value, and check if it is a root node,if yes we add to our global else move to root.right and root.left Return ans at end.

/**** Method 2 ****/
//Time Complexity: O(n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

// Rather than using a global variable, we can return the sum at leaf node.

public class _129_Sum_Root_to_Leaf_Numbers {

  /**** Method 1 ****/
  int ans;

  public int sumNumbers(TreeNode root) {
    if (root == null) {
      return 0;
    }

    ans = 0;
    helper(root, 0);
    return ans;
  }

  private void helper(TreeNode root, int sum) {
    if (root == null) {
      return;
    }

    sum = sum * 10 + root.val;

    if (root.left == null && root.right == null) {
      ans = ans + sum;
    }

    helper(root.left, sum);
    helper(root.right, sum);
  }

  /**** Method 2 ****/
  public int sumNumbers1(TreeNode root) {
    return helper1(root, 0);
  }

  private int helper1(TreeNode root, int sum) {
    if (root == null) return 0;

    sum = sum * 10 + root.val;

    if (root.left == null && root.right == null) {
      return sum;
    }

    return helper1(root.left, sum) + helper1(root.right, sum);
  }
}

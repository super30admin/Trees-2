/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// TC: O(n)
// SC: O(H) + O(k) - k is the number of paths from root to leaf, H is the height of the treen.


class Solution {
  public int sumNumbers(TreeNode root) {
    List<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    solve(root, list, sb);
    int sum = 0;
    for(int i=0; i<list.size(); i++) {
      System.out.println(list.get(i));
      sum += Integer.parseInt(list.get(i));
    }
    return sum;
  }


  public void solve(TreeNode root, List<String> list, StringBuilder sb) {

    if(root == null) {
      return;
    }


    sb.append(root.val);
    if(root.left == null && root.right == null) {
      list.add(new String(sb.toString()));
    }
    solve(root.left, list, sb);
    solve(root.right, list, sb);
    sb.deleteCharAt(sb.length() - 1);




  }

}
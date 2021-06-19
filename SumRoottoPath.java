// Time Complexity : O(n)
// Space Complexity : O(h) h -height of the tree
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


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
class Pair{
  TreeNode node;
  int value;
  public Pair(TreeNode node, int value) {
    this.node = node;
    this.value = value;
  }
  
  public TreeNode getKey() {
    return this.node;
  }
  public int getValue() {
    return this.value;
  }
}
class Solution {
  //int result;

  //iterative solution
    public int sumNumbers(TreeNode root) {
      if(root == null) return 0;
      Stack<Pair> st = new Stack<>();
      
      int result = 0; int currSum = 0;
      while(root != null || !st.isEmpty()) {
        while(root != null) {
          currSum = 10 * currSum + root.val;
          st.push(new Pair(root, currSum));
          root = root.left;
        }
        Pair p = st.pop(); 
        root = p.getKey(); // node
        currSum = p.getValue(); // curr corresponding to that node
        if(root.left == null && root.right == null) {
          result+= currSum;
        }
        root = root.right;
      }
      return result;
    }
}
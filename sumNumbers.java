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
class Solution {
  public int sumNumbers(TreeNode node) {
    int totalSum = 0, currentSum = 0;
    Deque<Pair<TreeNode, Integer>> nodeStack = new ArrayDeque();
    nodeStack.push(new Pair(node, 0));

    while (!nodeStack.isEmpty()) {
      Pair<TreeNode, Integer> currentNodePair = nodeStack.pop();
      node = currentNodePair.getKey();
      currentSum = currentNodePair.getValue();

      if (node != null) {
        currentSum = currentSum * 10 + node.val;
        // if it's a leaf, update the sum
        if (node.left == null && node.right == null) {
          totalSum += currentSum;
        } else {
          nodeStack.push(new Pair(node.right, currentSum));
          nodeStack.push(new Pair(node.left, currentSum));
        }
      }
    }
    return totalSum;
  }
}

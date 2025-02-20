// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
   }

   private int dfs(TreeNode node, int currentSum) {
       if (node == null) return 0;

       currentSum = currentSum * 10 + node.val; // Update path sum

       // If it's a leaf node, return the formed number
       if (node.left == null && node.right == null) {
           return currentSum;
       }

       // Recur for left and right subtrees and sum up the values
       return dfs(node.left, currentSum) + dfs(node.right, currentSum);
   }
    
}

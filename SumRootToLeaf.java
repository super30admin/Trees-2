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
class SumRootToLeaf {

    // Time Complexity: O(n)    (where n -> no. of nodes in the tree)
    // Space Complexity: O(h)   (where h -> height of the tree)

    int result = 0;
    public int sumNumbers(TreeNode root) {
        // Edge Case Checking
        if(root == null)
            return result;
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int sum){
        // Everytime we add the number to our sum till that point.
        sum = sum*10 + root.val;

        // Make recursive calls to move further down in the tree
        if(root.left != null)
            dfs(root.left, sum);
        if(root.right != null)
            dfs(root.right, sum);
        
        // When we reach the leaf node we add the sum value to our result and backtrack.
        if(root.left == null && root.right == null){
            result += sum;
            return;
        }
    }
}
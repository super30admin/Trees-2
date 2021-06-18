public class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    int total = 0;
    public int sumNumbers(TreeNode root){
        helper(root, 0);
        return total;
    }
    public void helper(TreeNode root, int sum) {
        if (root == null) 
            return;
        // when we traverse the tree, we should accumulate the results
        sum = sum * 10 + root.val;
        // when we meet the leaf nodes, we need compute the total
        if (root.left == null && root.right == null) {
            total += sum;
            return;
        }
        
        helper(root.left, sum);
        helper(root.right, sum);
    }
}
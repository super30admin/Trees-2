// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    int count = 0;
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    int sumNumbers(TreeNode root, int sum) {
    if (root == null) return 0;
    
    sum = sum*10 + root.val;
    if (root.left == null && root.right == null)
        return sum;
    
    return sumNumbers(root.left, sum) + sumNumbers(root.right, sum);
}
}
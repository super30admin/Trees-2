/*Time Complexity: O(n) traversing to every node and every path.
 * Space Complexity: O(1) no extra space but stack space will be there which is O(h).
 * Leetcode: yes
 * Any Issues: No
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    private int dfs(TreeNode node, int path)
    {
        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
            return path*10 + node.val;

        return  dfs(node.left, path*10 + node.val) + dfs(node.right, path*10 + node.val);
    }
    
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
}
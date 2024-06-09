/***
 Approach- Without using global variable-sum
 1. If root is null, return 0, else call the recursive function and pass the root and current sum as the local arguements. Keep sum as the global variable
 2. If current node is a leaf node, then update the sum with currentSum*10 + root.val
 3. Else, call recursion on root.left and root.right and update currentSum to currentSum*10+root.val
 TC - O(n), SC- O(h)
 */


class RootToLeafSum {
    public int sumNumbers(TreeNode root) {

        if(root == null)
            return 0;

        return dfs(root, 0);

    }

    private int dfs(TreeNode root, int curSum) {
        if(root == null)
            return 0;

        //Pre order traversal

        if(root.left == null && root.right == null) {
            return curSum * 10 + root.val;
        }

        int case1 = dfs(root.left, curSum*10 + root.val);
        int case2 = dfs(root.right, curSum*10 + root.val);

        return case1 + case2;
    }

    static class TreeNode {
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
}
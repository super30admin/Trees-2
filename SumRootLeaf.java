//Time Complexity - O(n)
//Space - O(h)
class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root,0);
        return sum;

        
    }
    private void dfs(TreeNode root, int currSum){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            sum = sum + currSum * 10 + root.val;
        }
        dfs(root.left, currSum * 10 + root.val);
        dfs(root.right, currSum * 10 + root.val);
    }
}
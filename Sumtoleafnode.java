//Time complexity : O(n)
//space complexity : O(h)
class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root, 0);
        return sum;
    }
    public void dfs(TreeNode root,int currSum) {
        //base case
        if(root == null){
            return;
        }
        currSum = currSum *10+root.val;
        if(root.left== null &&  root.right  == null){
            sum = sum + currSum;
            return;
        }
        dfs(root.left,currSum);
        dfs(root.right,currSum);
    }
}
// Time Complexity o(h) Space complexity o(h)
class Solution {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum;
    }
    public void helper(TreeNode root,int currSum){
        if(root == null) return;
        currSum=currSum*10 + root.val;
        if(root.left==null && root.right==null) {
            sum+=currSum;
            return;
        }
        helper(root.left,currSum);
        helper(root.right,currSum);


    }
}
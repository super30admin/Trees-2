
//Time Complexity: O(N)
//Space Complexity:O(h) h is the height of tree
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
         if(root == null)
             return sum;
        helper(root,0);
        return sum;
    }
    public void helper(TreeNode root,int curSum){
        //base case
        if(root == null)
            return;
        
        //logic
        curSum = curSum*10 + root.val;
        helper(root.left,curSum);
        if(root.left==null && root.right==null)
            sum+=curSum;
        helper(root.right,curSum);
    }
}
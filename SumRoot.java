//TC = O(n)
//SC = O(h)

class SumRoot{
    int sum;
    public int sumNumbers(TreeNode root) {
       helper(root,0);
       return sum;
    }

    private void helper(TreeNode root, int currSum){
         //base
        if(root==null) return;
        //logic
        currSum =  currSum * 10 + root.val;
        if(root.right == null && root.left == null){
            sum += currSum;
            return;
        }
        helper(root.left,currSum);
        helper(root.right, currSum);
    }
}
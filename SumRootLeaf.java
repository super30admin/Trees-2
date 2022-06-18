// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class SumRootLeaf {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int number){
        int result = 0;
        if(root.left==null && root.right==null){
            return number*10+root.val;
        }
        else{
            int newnum = number*10+root.val;
            if(root.right!=null){
                result+=helper(root.right, newnum);
            }
            if(root.left!=null){
                result+=helper(root.left, newnum);
            }
        }
        return result;
    }
} 
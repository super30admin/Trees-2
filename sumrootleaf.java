//Time Complexity:O(n)
//Space Complexity: O(n)


class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    private int helper(TreeNode root,int currsum){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return (currsum*10 + root.val);
        }
        int leftsum=helper(root.left,currsum*10+root.val);
        int rightsum=helper(root.right,currsum*10+root.val);
        return leftsum+rightsum;
    }
}
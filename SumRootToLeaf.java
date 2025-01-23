
// Definition for a binary tree node.
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
// Time Complexity : o(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yES
// Any problem you faced while coding this : nO


// Your code here along with comments explaining your approach
//We multiple with 10 and add node val untl root node is reached then we do same for right of root and we return sum

class SumRootToLeaf {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        sumNumbersHelper(root, 0);
        return sum;
    }
    public void sumNumbersHelper(TreeNode root, int currSum){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            sum+=currSum*10+root.val;
        }
        int left = (currSum*10+root.val);
        sumNumbersHelper(root.left, left);
        int right = (currSum*10+root.val);
        sumNumbersHelper(root.right, right);
    }
}
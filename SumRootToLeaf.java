// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes

public class SumRootToLeaf {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

     int result;
    public int sumNumbers(TreeNode root) {
        result =0;
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int currSum){
       if(root == null) return;

       currSum=currSum*10+ root.val;

       if(root.left==null && root.right==null){
           result+=currSum;
       }

       helper(root.left, currSum);
       helper(root.right, currSum);
    }


}

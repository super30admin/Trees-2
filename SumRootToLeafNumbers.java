// Time Complexity : O(n)
// Space Complexity : O(h) - height of tree
// Did this code successfully run on Leetcode : Yes

public class SumRootToLeafNumbers {

    public class TreeNode {
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

    int sum = 0;
    public int sumNumbers(TreeNode root) {
        sumLeafNodes(root, 0);
        return sum;
    }

    private void sumLeafNodes(TreeNode root, int currSum){

        //base
        if(root == null) return;

        if(root.left == null && root.right == null){
            sum+= currSum *10 + root.val;
            return;
        }

        //logic
        sumLeafNodes(root.left, currSum * 10 + root.val);
        //st.pop internally
        sumLeafNodes(root.right, currSum * 10 + root.val);

    }
}

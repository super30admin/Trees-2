package S30.Trees_2;

/*
Time Complexity : Put: O(n) - touching every node
Space Complexity : O(h) - height of stackframe/tree / O(n) if the tree is skewed
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class SumRootToLeafNumbers {

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

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return sum;
    }

    public void dfs(TreeNode root, int currentNumber){

        if(root == null) return;

        //currentNumber stays in the local stackframe for every recursive call
        currentNumber = currentNumber*10 + root.val;
        if(root.left == null && root.right == null){
            sum += currentNumber;
        }
        dfs(root.left,currentNumber);
        dfs(root.right,currentNumber);
    }
}

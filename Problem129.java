/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//
//Time Complexity: O(N) where n is the number of nodes
//Space complexity: O(N) for recurrssive stack

public class Problem129 {
    int sum;
    public int sumNumbers(TreeNode root) {
        this.sum=0;
        System.out.println(helper1(root,0));
        helper(root,0);
        return sum;
    }
    private void helper(TreeNode root,int currValue){
        //base condition
        if(root==null)
            return;

        //logic
        currValue=currValue*10+ root.val;
        if(root.left==null && root.right==null){
            sum=sum+currValue;
            return;
        }
        helper(root.left,currValue);
        helper(root.right,currValue);
    }

    private int helper1(TreeNode root,int currValue){
        //base condition
        if(root==null)
            return 0;

        //logic
        currValue=currValue*10+ root.val;
        if(root.left==null && root.right==null){
            return currValue;
        }
        int left=helper1(root.left,currValue);
        int right=helper1(root.right,currValue);

        return left+right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(0);

        Problem129 problem =new Problem129();
        System.out.println(problem.sumNumbers(root));
    }
}

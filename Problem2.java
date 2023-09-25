
//T.C  : O(n)
//S.C : O(h)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No
public class Problem2 {

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

    int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        inorder(root,0);
        return sum;

    }

    private void inorder(TreeNode root, int currSum){

        if(root == null) return;
        if(root.left == null && root.right == null){
            sum += currSum*10 + root.val;
        }
        inorder(root.left,currSum*10+ root.val);
        inorder(root.right,currSum*10 + root.val);

    }
}

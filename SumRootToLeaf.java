
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
class SumRootToLeaf {
    int sum;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    public void helper(TreeNode root, Integer value) {
        if(root==null)
            return;
        value = value*10 + root.val;
        if(root.left==null && root.right==null )
            sum = sum+value;

        helper(root.left, value);
        helper(root.right, value);
    }
}
public class sum {
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
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, Integer curr){
        //base
        if(root == null) return;

        //logic
        curr = curr*10 + root.val;

        if(root.right == null && root.left == null){
            sum += curr;
        }

        helper(root.left, curr);

        helper(root.right, curr);
    }
}

public class SumRootToLeafNumbers {
    int ans = 0;
    private void recursion(TreeNode root, int sum){
        if(root==null){
            return;
        }
        if(root.left == null && root.right == null){
            ans += ((sum*10) + root.val);
            return;
        }
        recursion(root.left, sum * 10 + root.val);
        recursion(root.right, sum * 10 + root.val);
    }
    public int sumNumbers(TreeNode root) {
        recursion(root, 0);
        return ans;
    }
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

}

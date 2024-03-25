   //tc = o(n) visiting all nodes
   //sc = o(h) height of tree 
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
 
class Solution {
    int sum = 0;
    public void helper(TreeNode root,int current){
        if(root == null)return; 
        current = current * 10 + root.val;
        if(root.left == null && root.right == null){
            sum = sum + current;
        }

        helper(root.left,current);
        helper(root.right,current);
    }
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum;
    }
}
//Time Complexity: O(N)
//Space Complexity: O(H), where H is the height of the tree (can be O(log N) for a balanced tree or O(N) for a skewed tree).
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
//I have taken result as global scope variable and used helper function, applying recursive calls
// and to calculate sum at every level by multiplying by 10 and adding to the global scope variable


public class problem2 {
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
  int result=0;
    public int sumNumbers(TreeNode root) {
        this.result=0;
        helper(root,0);
        return result;
    }
    public void helper(TreeNode root, int sum) {
        if(root==null) return;
        sum=sum*10+root.val;
        if(root.left==null && root.right==null) result+=sum;
        helper(root.left,sum);
        helper(root.right,sum);
    }
}

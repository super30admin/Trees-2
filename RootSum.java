// Time Complexity :  O(N)
// Space Complexity : O(H) where H is height of tree
// Did this code successfully run on Leetcode : Yes


class RootSum {
  int pathsum = 0;

  public int sumNumbers(TreeNode root) {
    helper(root, 0);  // start with root and 0 sum
    return pathsum; 
  }
    
     public void helper(TreeNode r, int num) {
    if (r != null) {
      num = num * 10 + r.val;  // Ex: to get 4 and then 49, you do 4*10+9 . This appends numbers
      
      if (r.left == null && r.right == null) { 
        pathsum += num; // if it's a leaf,add sum from root to leaf
      }
      helper(r.left, num); // leftsubtree
      helper(r.right, num) ; // right subtree
    }
  }
}
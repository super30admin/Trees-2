// Time Complexity : O(n)
// Space Complexity : O(height)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
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
class Pair {
    
  TreeNode root;
  int curSum = 0;
  
  //constructor to check pairs and store it in stack
  public Pair(TreeNode root, int curSum){
      this.root = root;
      this.curSum = curSum;
  }
  
  //function to get root node
  public TreeNode getKey(){
      return this.root;
  }
  
  //function to get curSum
  public int getValue(){
      return this.curSum;
  }
}
class Solution {
  
  public int sumNumbers(TreeNode root) {
      if(root == null)
          return 0;
      
      //check stack of pair, where pair contains TreeNode and current Sum
      //create pair class to store these values
      Stack<Pair> stack = new Stack<>();
      
      int curSum = 0, result = 0;
      
      //iterative approach
      while(root != null || !stack.isEmpty()){
          
          //left
          while(root != null){
              curSum = curSum * 10 + root.val;
              stack.push(new Pair(root, curSum));
              root = root.left;
          }
          
          //root
          Pair p = stack.pop();
          root = p.getKey();
          curSum = p.getValue();
          
          //check if root is leaf node or not
          if(root.left == null && root.right == null){
              result += curSum;
          }
          
          //right
          root = root.right;
      }
      
      return result;
  }
}
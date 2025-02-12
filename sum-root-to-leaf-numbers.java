// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :i have used recursive void type approach to implement this and 
// i have mainatined each path suma as local variable because it should overwrite for every new path as well as result as global variable because it should carry all the previous path sums. 


// Your code here along with comments explaining your approach

class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
       helper(root,0);
       return result;
    }
    public void helper(TreeNode root,int curr){
    if(root == null)return;
    
      curr=curr*10+root.val;
      if(root.left == null && root.right==null){
        result+=curr;
    }
      helper(root.left,curr);
      helper(root.right,curr);
    }
}



// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach: i have used recursive int return type approach to implement this and 
// i have mainatined each path suma as local variable because it should overwrite for every new path as well as result as global variable because it should carry all the previous path sums. 


class Solution {
    public int sumNumbers(TreeNode root) {
      return helper(root,0);
    }
    public int helper(TreeNode root,int curr){
    if(root == null)return 0;
    
      curr=curr*10+root.val;
      if(root.left == null && root.right==null){
        return curr;
    }
     int left= helper(root.left,curr);
     int right= helper(root.right,curr);
       return left+right;
    }
}
// Time Complexity :o(N)
// Space Complexity :Worst case O(N) or  o(height if tree)
// Did this code successfully run on Leetcode :  YES
// Any problem you faced while coding this :
//Yes still working on problem.

// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  Integer result;
      
 public int sumNumbers(TreeNode root) {
      result=0;
     pathsum(root,0);
     return result;         
 }
 private void pathsum(TreeNode node,int runningsum){ 
     
     if (node ==null) return;
        runningsum =(runningsum*10)+node.val;
        System.out.println("node val   "+node.val+"   runningsum   "+runningsum);
     if(node.left ==null && node.right ==null){
         System.out.println(result + " " +runningsum); 
         result =result+runningsum;
          System.out.println("result"+result);
         return;
     }

     if(node.left!=null){
       pathsum(node.left,runningsum);  
     }
      if(node.right!=null){
    pathsum(node.right,runningsum);
      }
         
}
}
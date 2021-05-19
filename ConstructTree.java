import java.util.Map;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*We form the Tree in a recursive manner using a map to keep track of the indices in the InOrder Array.*/
//Further, we decrement the index of the PostOrder Array during each recursive call.


class Solution {
    Map<Integer,Integer> dic;
   int index;
   public TreeNode buildTree(int[] inorder, int[] postorder) {
       dic=new HashMap<>();
       index=postorder.length-1;
       for(int i=0;i<inorder.length;i++){
           dic.put(inorder[i],i);
       }
       return helper(postorder,0,postorder.length-1);  
   }
   
   public TreeNode helper(int[] postorder,int left,int right){
       if(left>right)
           return null;
       int rootval = postorder[index--];
     
       TreeNode root = new TreeNode(rootval);
       
       
       root.right=helper(postorder,dic.get(rootval)+1,right);
       root.left=helper(postorder,left,dic.get(rootval)-1);
       return root;
   }
}

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

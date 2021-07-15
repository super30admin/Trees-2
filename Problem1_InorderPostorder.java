// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
   int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        if(n==0) return null;
        if(n==1) return new TreeNode(postorder[0]);
        postIndex = n-1;
        return helper(inorder, postorder, 0, n-1);
        
    }
    
     TreeNode helper(int[] inorder, int[] postorder, int inLeft, int inRight){
        if(inLeft > inRight) 
            return null;
         
         TreeNode root=new TreeNode(postorder[postIndex--]);
          int curr = findIndex(inorder, root.val);
         
         root.right=helper(inorder,postorder,curr+1,inRight);
         root.left=helper(inorder,postorder,inLeft,curr-1);
         
         return root;
     }
    
     int findIndex(int[] inorder, int key){
        for(int i = inorder.length-1; i>=0; i--){
            if(inorder[i] == key) return i;
        }
        return -1;
    }
}
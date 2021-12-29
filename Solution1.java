import java.util.HashMap;

// Time Complexity :O(n) touching all nodes once
// Space Complexity :O(n)+O(h) n for the hashmap and h for the recursive calls in the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No 


// Your code here along with comments explaining your approach

class Solution {

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
   //Using Recursion
    HashMap<Integer,Integer> map;
   int idx;
   public TreeNode buildTree(int[] inorder, int[] postorder) {
       if(postorder==null ||postorder.length==0||inorder==null)
           return null;
       map=new HashMap<>();
       idx=postorder.length-1;
       for(int i=0;i<inorder.length;i++){
           map.put(inorder[i],i);
       }
       
       return helper(postorder,0,postorder.length-1);
   }
   
   private TreeNode helper(int[] postorder, int start,int end){
       
       //base case
       if(start>end)
           return null;
       
       //logic
       int rootVal=postorder[idx];
       idx--;
       int rootIdx=map.get(rootVal);
       TreeNode root=new TreeNode(rootVal);
      
       root.right=helper(postorder,rootIdx+1,end); 
       root.left=helper(postorder,start,rootIdx-1);
       
       return root;
   }
}
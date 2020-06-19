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
class Solution {
    int index;
    HashMap<Integer,Integer> map;
   
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
      for(int i = 0 ;i< inorder.length ;i++) {
          map.put(inorder[i],i);
      }
        index = postorder.length - 1;
        return helper(inorder,postorder,0,inorder.length - 1);
    }
   
    private TreeNode helper(int[] inorder, int[] postorder,int start,int end){
        if(index < 0 || start > end){
            return null;
        }
       
       
        TreeNode root = new TreeNode(postorder[index]);
        int inorderIdx = map.get(root.val);
        index--;  
       
        root.right = helper(inorder,postorder,inorderIdx + 1, end); //right recursion first because post order
        root.left = helper(inorder,postorder,start,inorderIdx - 1);
       
        return root;
       
    }
   
}

/*
Time & Space complexity : O(n) each node is accessed once and hashmap is created for n nodes
*/

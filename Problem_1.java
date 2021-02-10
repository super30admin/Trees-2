//Time O(n)
//Space: O(max depth)
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
  private int postIndex;
  private HashMap<Integer,Integer> map;
  
    public TreeNode buildTree(int[] inorder, int[] postorder) {
     
      if(postorder == null || inorder == null){
        return null;
      }
      int inStart = 0;
      int inEnd = inorder.length-1;
     
       map = new HashMap<>();
    
      for(int i=0;i<inorder.length;i++){
        map.put(inorder[i],i);
      }
      
       postIndex = postorder.length-1;
      return recurr(inorder,postorder,inStart,inEnd);
        
    }
  private TreeNode recurr(int[] inorder, int[] postorder,int inStart, int inEnd){
    if(inStart > inEnd){
      return null; // leaf node
    }
     
   
      
    TreeNode root = new TreeNode(postorder[postIndex]);
    
    postIndex -= 1;
    
    //Root, Right.Left
    int index = map.get(root.val);
    
    
    
    root.right  = recurr(inorder,postorder,index+1,inEnd);
    root.left = recurr(inorder,postorder,inStart,index-1);
    
    return root;
    
  }
      
}

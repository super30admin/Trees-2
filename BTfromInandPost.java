// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {

    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
       return buildMyTree(inorder, postorder , 0 , inorder.length , 0 , postorder.length);
          
    }
    
     public TreeNode buildMyTree(int[] inorder, int[] postorder , int inFrom , int inTo , int postFrom , int postTo) {
        
        if(postTo <= postFrom || inTo <= inFrom){
            return null;
        }
         
        TreeNode root = new TreeNode(postorder[postTo - 1]);
        
        if(postTo - postFrom == 1){
            return root;
        }
    
       int index = map.get(root.val);
        
       root.right =  buildMyTree(inorder, postorder, index +1, inTo , postFrom + index - inFrom , postTo -1);
       root.left =  buildMyTree(inorder, postorder , inFrom , index , postFrom, postFrom + index - inFrom);
        
       return root;
        
        
    }
}

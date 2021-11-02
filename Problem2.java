// Problem 106 - Construct Binary Tree from Inorder and Postorder Traversal
// Time Complexity : O(N)
// Space Complexity : O(N)
class Solution {
    
    int p;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      
        p = postorder.length - 1;
        
        HashMap<Integer, Integer> map = new HashMap();
        
        for(int i = 0; i<inorder.length; i++){
            
            map.put(inorder[i], i );
        }
        
        return helper(postorder, map, 0, inorder.length - 1);
        
        
    }
    
    public TreeNode helper(int[] postorder, HashMap<Integer, Integer> map, int start, int end){
        
        if(start > end){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[p]);
        int inorderIndex = map.get(root.val);
        p--;
        
    	root.right=helper(postorder,map, inorderIndex+1,end);
	    root.left=helper(postorder,map,start,inorderIndex-1);
        
        return root;
    }
}
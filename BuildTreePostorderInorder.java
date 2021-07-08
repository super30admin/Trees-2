// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
no

// Your code here along with comments explaining your approach


class Solution {
    int i;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
       if(inorder.length == 0 || postorder.length == 0)
         return null;
        map = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i],i);
        }
        i = postorder.length - 1;
        return helper(inorder,postorder,0,inorder.length-1);
        
    }
    
    
    private TreeNode helper(int[] inorder,int[] postorder ,int low , int high){
        
        if( low > high || i < 0)
            return null;
        
        int index = map.get(postorder[i]);
        TreeNode root = new TreeNode(inorder[index]);
        i--;
        root.right =  helper(inorder, postorder,index+1,high);
        root.left =  helper(inorder,postorder, low, index-1 );
        
        return root;
        
    }
}
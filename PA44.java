//106. Construct Binary Tree from Inorder and Postorder Traversal
//Time complexity : O(n) // n is the number of nodes in tree
//Space Complexity: O(n) // n is the height of tree in worst case it is equal to no of nodes in tree


class Solution {
    int index=0;
    HashMap<Integer, Integer> hm;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        hm= new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        index=postorder.length-1;
        return helper(inorder, postorder, 0, inorder.length-1);
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int start, int end){
        
        if(start>end || index<0){
            return null;
        }
        
        int rval= postorder[index];
        index--;
        TreeNode root = new TreeNode(rval);     
        int m= hm.get(rval);
        if(start==end){
            return root;
        }
        root.right= helper(inorder, postorder, m+1, end);
        root.left= helper(inorder, postorder, start, m-1);
        
        
        
        return root;
        
    }
}
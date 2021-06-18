//time complexity:O(n)
//space complexity:O(n)

class Solution {
    
    int rootCounter;
    Map<Integer, Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        rootCounter= postorder.length-1;//the root is at the end 
        return helper(0, inorder.length-1, postorder);
    }
    
    public TreeNode helper(int start, int end, int[] postorder){
        if(start>end) return null;
        if(rootCounter<0) return null;
        
        TreeNode root=new TreeNode(postorder[rootCounter]);//
        rootCounter--;//decrement to get the root in sub trees
        
        int rootIndexInorder=map.get(root.val);
        
        root.right= helper(rootIndexInorder+1, end, postorder);//forms the right subtree
        root.left=helper(start, rootIndexInorder-1, postorder);//forms the left subtree
        return root;
    }
}

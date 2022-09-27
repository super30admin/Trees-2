class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int postIndx;
    
    public TreeNode helper(int[] postorder, int inS, int inE){
        if(inS > inE) return null;
        
        TreeNode node = new TreeNode(postorder[postIndx]);
        postIndx--;
        
        node.right = helper(postorder, map.get(node.val) + 1, inE);
        node.left = helper(postorder, inS, map.get(node.val) - 1);
        
        
        return node;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //Given inorder and postorder
        //postorder the root is always at the end
        //inorder root is some where in between
        
        //postorder traversal the last value is a root, then its right child, then its left child, etc. ---> (Coming form back)
        
        //Time Complexity: O(N)
        //Space Complexity: O(N) As we used hashmap
        postIndx = postorder.length - 1;
        int inS = 0;
        int inE = inorder.length - 1;
        
        for(int i = 0; i <= inE; i++){
            map.put(inorder[i], i);
        }
        return helper(postorder, inS, inE);
    }
}
/**
 * Q. Construct Binary Tree from Inorder and Postorder Traversal
 * 
 * Approach - Same as for constructing BT with inorder and preorder, only
 * difference is that we will traverse the Postorder list from back. 
 * 
 * Time Complexity - O(n) Space Complexity - O(n)
 */
class Solution {
    int preIndex = 0;
    int[] inOrder;
    int[] preOrder;
    HashMap<Integer,Integer> inOrderInx = new HashMap<>();
    
    private TreeNode helper(int left_in, int right_in){
        
        if(left_in - right_in == 1) return null;
        
        int preVal =  preOrder[preIndex];
        preIndex+=1;
        
        
        TreeNode root = new TreeNode(preVal);
        int rootIdx = inOrderInx.get(preVal);
        
        
        root.left = helper(left_in, rootIdx-1);
        root.right = helper(rootIdx+1,right_in);
            
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        inOrder = inorder;
        preOrder = preorder;
        
        int i = 0;
        for(int num:inorder) inOrderInx.put(num, i++);
        

        return helper(0, inorder.length-1);
        
    }
}
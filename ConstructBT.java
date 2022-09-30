// Optimized Approach : Using HashMap

class Solution {
    
    //key : nos & value : index
    HashMap<Integer, Integer> map = new HashMap<>();
    int postIndex;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)
            return null;
        
        postIndex = postorder.length - 1;
        
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper(inorder, postorder, 0, postorder.length - 1);
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int start, int end){
        //base case
        if(start > end)
            return null;
        
        //build a node
        int rootVal = postorder[postIndex];
        postIndex--;
        int rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        
        //For postorder traversal we are traversing from end of the array so we will have to process the right node first and then the left node as the postorder is : Left Right Root
        
        //create a right subtree
        root.right = helper(inorder, postorder, rootIdx + 1, end);
        
        //create a left subtree
        root.left = helper(inorder, postorder, start, rootIdx - 1);
        
        return root;
    }
}

//Time Complexity :O(n)
//Space Complexity :O(n)
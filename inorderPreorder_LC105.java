//Approach 1 : brute force - TC O(n^2) since we are search for root index in inorder array for each recursive call
// and SC is O(n^2) - creating deep copy for each recursive call
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    
        //base case if preorder is null return null
        if(preorder.length==0) 
        {
            return null;
        }
        
        //find the root value from preorder, first element
        int rootval = preorder[0];
        
        //form the root node with rootval
        TreeNode root = new TreeNode(rootval);
        
        //find the root's index in inorder so left of root is left subtree and right of root is right subtree
        int rootindex = 0;
        for(int i =0; i<inorder.length;i++){
            if(inorder[i]==rootval){
                rootindex = i;
                break;
            }
        }
        
        //with the root index in inorder array find the new in order and pre order for left subtree and right subtree
        //copyOfRange - function parameters(array,first index, lastindex+1) similar to substring
        int [] inorderleft = Arrays.copyOfRange(inorder,0 , rootindex);
        int [] inorderright = Arrays.copyOfRange(inorder, rootindex+1, inorder.length);
        int [] preorderleft = Arrays.copyOfRange(preorder, 1 , inorderleft.length+1 );
        int [] preorderright = Arrays.copyOfRange(preorder,inorderleft.length+1 ,preorder.length);
      
        //recursive call the left subtree and right subtree
        root.left = buildTree(preorderleft,inorderleft);
        root.right =  buildTree(preorderright, inorderright);
        
        return root;
        
        //use hashmap for reducing the search to O(n)
        //use index for passing the subtrees instead of new array copies
        
    }
}
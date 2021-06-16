// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length == 0 ) return null;  //if the null is empty return null 
        int val = preorder[0]; //calculate the root node
        
        TreeNode root = new TreeNode(val); //create a node
        int rootIndex = 0;
        
        for(int i = 0; i < inorder.length; i++)
        {
            if(inorder[i] == val)
            {
                rootIndex = i; //find the root node index in the inorder traversal
            }
        }
        
        int[] preLeft = Arrays.copyOfRange(preorder, 1, rootIndex+1); //the left of the tree will be the 1 to rootindex since preorder traversal 
        int[] preRight = Arrays.copyOfRange(preorder, rootIndex+1, preorder.length); // right will be rootindex+1 to end since preorder traversal
        int[] inLeft = Arrays.copyOfRange(inorder, 0 , rootIndex); // the left will be 0 to rootindex-1 since inorder traversal
        int[] inRight = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length); //the right will be rootindex+1 till end since inorder traversal
        
        root.left = buildTree(preLeft, inLeft); //build tree recursively 
        root.right = buildTree(preRight, inRight); 
        
        return root; 
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach

class Solution2 {
    
    int curr = 0;
    int result = 0; 
    
    public int sumNumbers(TreeNode root) {
    
        helper(root, curr); 
        
        return result; 
    }
    
    private void helper(TreeNode root, int curr)
    {
        if(root == null) return; 
        
        curr = curr * 10 + root.val; //curr at any node is prev curr * 10 + current root value
        helper(root.left, curr); //inorder left 
        
        if(root.left == null && root.right == null) result = result + curr; //if leaf node, add it to the result
        
        helper(root.right, curr); //inorder right
        
        
    }
}
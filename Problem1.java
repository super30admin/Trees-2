
// Time Complexity - O(n^2) where n are the number of nodes in the tree
//Space Complexity - O(n^2) where n are the number of nodes in the tree
// This solution worked on LeetCode



class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return(helper(inorder,postorder));    
    }
    
    private TreeNode helper(int[] inorder, int[] postorder){
        if(postorder.length == 0 || postorder == null)   return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);  // using postorder traversal to find the root.
        int index =-1;
        for(int i=0;i<inorder.length;i++){        // Find the root in inrder traversal
            if(inorder[i] == root.val){             
                index = i;                        // find the index of root in inorder traversal
                break;
            }    
        }
        // Using the index we find the left subtree and right subtree from inorder traversal and iterate until any of the postorder or inorder array is empty
        int[] inleft = Arrays.copyOfRange(inorder,0,index);               
        int[] inright = Arrays.copyOfRange(inorder,index+1,inorder.length);
        int[] postleft = Arrays.copyOfRange(postorder,0,index);
        int[] postright = Arrays.copyOfRange(postorder,index,postorder.length-1);
        root.left = buildTree(inleft,postleft);
        root.right = buildTree(inright,postright);
        return root;
    }
}

// Time Complexity :O{n2} Traversal + recursion at each node
// Space Complexity :O(n2) -> Recursive and stack
// Did this code successfully run on Leetcode :Yes 
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        //PostOrder traverse is lrn and Inorder traverse in lnr
        //The last value in postorder array is the root
        //Find that root in the Inorder and get the index . Elements to the left of the root in the inorder is the left subtree  and to the right is the right subtree    
        //Now looking at the postorder, the same indices that built the left subtree of inorder will be the post order left subtree and that builds the right subtree is the roodindex to n-1

        if(postorder == null || postorder.length ==0)
            return null;
        
        //find root in inorder
        int n = postorder.length; //it can inorder length as well.Either of these
        int rootVal = postorder[n-1];
        TreeNode root = new TreeNode(rootVal);
        
        //search root in inorder
        int rootIdx = 0;
        for(int i = 0; i < inorder.length ; i++){
            if(inorder[i] == rootVal)
                rootIdx = i;
        }
        
        int[] postLeft = Arrays.copyOfRange(postorder, 0, rootIdx);
        int[] postRight = Arrays.copyOfRange(postorder, rootIdx, n-1);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);//unlike substring, copyOfRange will exclude the end index
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
        
        
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        
        return root;
        
    }
}
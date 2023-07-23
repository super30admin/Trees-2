//106. Construct Binary Tree from Inorder and Postorder Traversal

// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    // int rootIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || inorder == null ||  inorder.length == 0) return null;
        int rootVal = postorder[postorder.length - 1];
        int rootIdx = -1;
        TreeNode root = new TreeNode(rootVal);
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                System.out.println(rootIdx);
                rootIdx = i;
                System.out.println(rootIdx);
                break;
            }
        }
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0 , rootIdx);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootIdx + 1 , inorder.length);
        
        int[] postorderLeft = Arrays.copyOfRange(postorder, 0 , rootIdx);
        int[] postorderRight = Arrays.copyOfRange(postorder, rootIdx + 1 , postorder.length - 1);
        
        root.left = buildTree(postorderLeft, inorderLeft);
        root.right = buildTree(postorderRight, inorderRight);
        
        return root;
    }
}
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
// Use recursion to create the Binary Tree from the given 2 traversals
// The last element in the postorder will always be the root and the elements to left of it in the inorder array
// will be a part of the left subtree and the elements to the right of the root in the inorder array will be a part of the right subtree

class Solution {
    Map<Integer, Integer> inOrderMap = new HashMap<>();
    int postOrderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIndex = postorder.length-1;
        for(int i=0; i< inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        
        return buildBST(postorder, 0, postorder.length-1);
    }
    
    private TreeNode buildBST(int[] postorder, int start, int end) {
        if(start>end)
            return null;
        
        int rootValue = postorder[postOrderIndex--];
        TreeNode root = new TreeNode(rootValue);
        int inOrderIndex = inOrderMap.get(rootValue);
        
        root.right = buildBST(postorder, inOrderIndex+1, end);
        root.left = buildBST(postorder, start, inOrderIndex-1);
        
        return root;
    }
}
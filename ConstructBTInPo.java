// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return helper(postorder, postorder.length - 1, 0, inorder, inorder.length - 1, 0, inorderIndex);
    }
    
    private TreeNode helper(int[] postorder, int postRight, int postLeft,
                           int[] inorder, int inRight, int inLeft, 
                            Map<Integer, Integer> inorderIndex) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postRight]);
        int inMid = inorderIndex.get(postorder[postRight]);
        int rightSize = inRight - inMid;
        root.right = helper(postorder, postRight - 1, postRight - rightSize, 
                            inorder, inRight, inMid + 1, inorderIndex);
        root.left = helper(postorder, postRight - rightSize - 1, postLeft, 
                          inorder, inMid - 1, inLeft, inorderIndex);
        return root;
    }
}
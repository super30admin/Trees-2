// Time Complexity : O(n) --> where n is length of input (preorder / inorder) array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (106): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    HashMap<Integer, Integer> map;
    int index; // index of roots in preorder
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        // edge case
        if (postorder.length == 0 || inorder.length == 0) return null;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int start, int end) {
        // base case
        if (start > end || index >= postorder.length) return null;
        
        // logic
        int inIdx = map.get(postorder[index]);
        TreeNode root = new TreeNode(postorder[index]);
        index--;
        root.right = helper(inorder, postorder, inIdx + 1, end);
        root.left = helper(inorder, postorder, start, inIdx - 1);
        return root;
    }
}
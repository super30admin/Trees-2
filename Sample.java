//Construct Binary tree from inorder and postorder traversal
// Time Complexity : O(depth)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    HashMap<Integer, Integer> inorderMap;
    int postIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null) {
            return null;
        }
        postIdx = inorder.length-1;
        
        inorderMap = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return helper(inorder, postorder, 0 , inorder.length - 1);
        
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int start, int end) {
        if(start > end) {
            return null;
        }
        int rootVal = postorder[postIdx--];
        TreeNode root = new TreeNode(rootVal);
        
        int rootIdx = inorderMap.get(rootVal);
        
        root.right = helper(inorder, postorder, rootIdx + 1, end);
        root.left = helper(inorder, postorder, start, rootIdx-1);
        return root;
    }
}
//-----------------------------------------------------------------------//
//Sum root to leaf numbers
// Time Complexity : O(depth)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        result = 0;
        helper(root, 0);
        return result;
    }
    
    private void helper(TreeNode root, int tempSum) {
        if(root == null) {
            return;
        }
        tempSum = tempSum * 10 + root.val;
        helper(root.left, tempSum);
        if(root.left == null && root.right == null) {
            result += tempSum;
        }
        helper(root.right,tempSum);
    }
}
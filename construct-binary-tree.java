// Time - O(N)
// Space - O(N)
class Solution {
    
    HashMap<Integer, Integer> in_index = new HashMap<Integer,Integer>();
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) {
            return null;
        }
        
        for(int i=0;i<inorder.length;i++) {
            in_index.put(inorder[i], i);
        }
        
        return helper(preorder, 0, preorder.length - 1);
    }
    
    public TreeNode helper(int[] preorder, int start, int end) {
        if(start > end) {
            return null;
        }
        int nextRootId = in_index.get(preorder[idx]);
        
        TreeNode root = new TreeNode(preorder[idx]);
        idx++;
        root.left = helper(preorder, start, nextRootId - 1);
        root.right = helper(preorder, nextRootId + 1, end);
        
        return root;
    }
}

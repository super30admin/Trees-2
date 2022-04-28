// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class ConstructBinaryTree {
    Map<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    
        if(inorder == null || postorder == null || inorder.length != postorder.length) return null;
        
        map = new HashMap<>();
        idx = postorder.length - 1;
        
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return helper(postorder, 0, postorder.length - 1);
    }
    
    private TreeNode helper(int[] postorder, int start, int end) {
        if(start > end || idx < 0) return null;
        
        int rootVal = postorder[idx];
        idx--;
        
        TreeNode root = new TreeNode(rootVal);
        
        int rootIdx = map.get(rootVal);
        
        root.right = helper(postorder, rootIdx + 1, end);
        root.left = helper(postorder, start, rootIdx - 1);
        
        return root;
    }
}

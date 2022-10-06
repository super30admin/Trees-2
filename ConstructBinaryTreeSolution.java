// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class ConstructBinaryTreeSolution {
    public Map<Integer, Integer> map;
    public int postIndex;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        map = new HashMap<>();
        postIndex = postorder.length - 1;
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = helper(postorder, inorder, 0, inorder.length - 1);
        return root;
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        if(start > end) {
            return null;
        }
        int rootValue = preorder[postIndex];
        postIndex--;
        
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = map.get(rootValue);
        root.right = helper(preorder, inorder, rootIndex + 1, end);
        root.left = helper(preorder, inorder, start, rootIndex - 1);
        return root;
    }
}

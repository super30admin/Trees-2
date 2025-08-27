import java.util.HashMap;

class BuildTree {
    HashMap<Integer,Integer> map;
    int postorderIndex;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        if (inorder.length == 0 || postorder.length == 0) return null;
        
        this.map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return helper(postorder, 0, inorder.length - 1);
    }
    
    public TreeNode helper(int[] postorder, int start, int end) {
        if (start > end) return null;
        
        int rootVal = postorder[postorderIndex--];
        int rootIndex = map.get(rootVal);
        
        TreeNode root = new TreeNode(rootVal);
        root.right = helper(postorder, rootIndex + 1, end);
        root.left = helper(postorder, start, rootIndex - 1);
        
        return root;
    }
}

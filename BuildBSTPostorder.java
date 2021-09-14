public class BuildBSTPostorder {
    private HashMap<Integer, Integer> inorderMap;
    private int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        index = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length - 1);
        
    }
    
    private TreeNode helper(int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootValue = postorder[index--];
        int sindex = inorderMap.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        root.right = helper(postorder, sindex + 1, right);
        root.left = helper(postorder, left, sindex - 1);
        return root;
    }
}

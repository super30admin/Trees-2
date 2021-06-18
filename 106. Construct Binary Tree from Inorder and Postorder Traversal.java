class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    Map<Integer, Integer> map = new HashMap<>();
    int len;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        len = postorder.length - 1;
        // construct map for inorder
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        } 
        return helper(postorder, 0, len);
    }
    public TreeNode helper(int[] postorder, int left, int right){
        if(left > right)
            return null;
        int root_val = postorder[len--];
        int idx = map.get(root_val);
        TreeNode root = new TreeNode(root_val);
        // we must firstly construct right subtree
        root.right = helper(postorder, idx + 1, right);
        root.left = helper(postorder, left, idx - 1);
        
        return root;
    }
}
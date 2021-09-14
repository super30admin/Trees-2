//Time complexity: O(N)
//Space complexity: O(N)
class Solution {    
    public int post_index;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        post_index = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return helperMethod(postorder, 0, postorder.length - 1);
    }
    
    public TreeNode helperMethod(int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[post_index--]);
        
        root.right = helperMethod(postorder, map.get(root.val) + 1, end);
        root.left = helperMethod(postorder, start, map.get(root.val) - 1);

        return root;
    }
}
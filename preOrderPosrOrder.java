//Time Complexity: O(n)
//Space Complexity: O(1)

class Solution {
    int idx;
     private HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder == null || inorder.length == 0 || preorder == null || preorder.length == 0) {
            return null;
        }

        map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootVal= preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        root.left = helper(preorder, start, rootIdx - 1);
        root.right = helper(preorder, rootIdx+1, end);

        return root;
    }

}
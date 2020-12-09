/** Given inorder and postorder traversal of a tree, construct the binary tree.
* TC O(N) Space complexity O(N) - We are only using array index and not storing the additional pieces of array on stack
* Code was submitted on leetcode
/
class Solution {
    HashMap<Integer, Integer> inorderMap;
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = new TreeNode();
        if (inorder == null || inorder.length == 0)
            return null;
        inorderMap = new HashMap<>();
        for (int i = 0; i< inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        index = postorder.length - 1;
        return helper(postorder, 0, inorder.length -1);
    }
    private TreeNode helper(int [] postOrder, int start, int end) {
        if (start > end)
            return null;
        int rootVal = postOrder[index];
        TreeNode root = new TreeNode(rootVal);
        index --;
        int rootIndex = inorderMap.get(rootVal);
        
        root.right = helper(postOrder, rootIndex+1, end);
        root.left = helper(postOrder, start, rootIndex-1);
        return root;
    }
}

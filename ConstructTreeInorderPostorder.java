// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


class Solution {
    int index = 0;
    HashMap<Integer, Integer> map = new HashMap();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)       {
            return null;
        }

        index = postorder.length - 1;
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int start, int end){
        if(index < 0 || start > end){
            return null;
        }
        int inorderIndex = map.get(postorder[index--]);
        TreeNode root = new TreeNode(inorder[inorderIndex]);
        if(start == end){
            return root;
        }
        root.right = helper(inorder, postorder, inorderIndex+1, end);
        root.left = helper(inorder, postorder, start, inorderIndex-1);
        return root;
    }
}
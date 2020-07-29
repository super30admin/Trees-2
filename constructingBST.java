/* Time complexity: O(n), as we are traversing through the entire array of inorder traversal
Space complexity: O(n)  */

class Solution{
    HashMap<Integer, Integer> map;
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder){
        i(preorder.length == 0 && inorder.length == 0) return null;
        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length-1);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        if(idx == preorder.length || start > end) return null;
        int rootIdx = map.get(preorder[idx]);
        idx++;
        TreeNode root = new TreeNode(preorder[idx]);
        root.left = helper(preorder, inorder, start, rootIdx-1);
        root.right = helper(preorder, inorder, rootIdx+1, end);
        return root;
    }
}
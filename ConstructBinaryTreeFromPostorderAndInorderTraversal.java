// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    int index;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.index = postorder.length-1;
        this.map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] postorder, int start, int end){
        //base 
        if(start > end)
            return null;
        //logic
        TreeNode root = new TreeNode(postorder[index]);
        int p = map.get(root.val);
        index--;
        root.right = helper(postorder, p+1, end);
        root.left = helper(postorder, start, p-1);
        return root;
    }
}

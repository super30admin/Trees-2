// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// In Postorder last element will always give us root
// Once we have the value of root, we can search for it in inorder array, and we get get right and left subtree split
// For each of these subtrees we can recursively find root, right and left subtree and move down the tree till we reach a leaf node

class Solution {
    HashMap<Integer, Integer> map;
    int rootIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        rootIdx = inorder.length-1;
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return helper(inorder, postorder, 0, inorder.length-1);
    }
    private TreeNode helper(int[] inorder, int[] postorder, int start, int end){
        if(start>end)
            return null;
        int index=-1;
        TreeNode root = new TreeNode(postorder[rootIdx]);
        index = map.get(postorder[rootIdx]);
        rootIdx--;
        root.right = helper(inorder, postorder, index+1, end);
        root.left = helper(inorder, postorder, start, index-1);
        return root;
    }
}
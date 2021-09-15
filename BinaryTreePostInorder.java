// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int idx = 0; // post order array traversal pointer
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;
        idx = postorder.length - 1;
        // fill the hashmap with elements in inorder array and their index
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        // call recursive function
        return helper(inorder, postorder, 0, inorder.length - 1);
    }
    private TreeNode helper(int[] inorder, int[] postorder, int start, int end){
        // base
        // return if start and end pointers on inorder array cross each other
        if(start > end) return null;
        // get the root element's index in inorder array from the map
        int rootIdx = map.get(postorder[idx]);
        // create a new node
        TreeNode root = new TreeNode(postorder[idx]);
        // decrement the post order array traversal pointer
        idx--;
        // recursively build right sub tree
        root.right = helper(inorder, postorder, rootIdx + 1, end);
        // recursively build left sub tree
        root.left = helper(inorder, postorder, start, rootIdx - 1);
        return root;
    }
}
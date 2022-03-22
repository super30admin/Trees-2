// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Create a hashmap where we will store the map of inorder values and their index
//Now we will call a recursive funtion with parameters postorder[], left and right
//We will put the exit condition when l > r
//Since postorder stores index of root at last so we will start from last value as root first
//Now we will recursively call this function passing the limits after getting the actual positions in inorder hashmap
//This way we will build our tree and return the root node.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer, Integer> inorIndexMap;
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorIndexMap = new HashMap<>();
        postIndex = postorder.length - 1;
        for(int i = 0; i < inorder.length; i++){
            inorIndexMap.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postorder.length - 1);
    }
    private TreeNode buildTree(int[] postorder, int l, int r){
        if(l > r)
            return null;
        int rootVal = postorder[postIndex--];
        int index = inorIndexMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.right = buildTree(postorder, index + 1, r);
        root.left = buildTree(postorder, l, index - 1);
        return root;
    }
}
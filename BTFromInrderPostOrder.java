// Time Complexity : O(N^2) where N os number of elements given and copy of elements
// Space Complexity : O(N^2) beacuse of arrys creation
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = -1;
        for(int i=0; i<inorder.length; i++) {
            if(rootVal == inorder[i]){
                rootIdx = i;
                break;
            }
        }

        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootIdx +1, inorder.length);

        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, rootIdx+1);
        int[] preorderRight = Arrays.copyOfRange(preorder, rootIdx+1, preorder.length);

        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);

        return root;
    }
}

//to save time and space
// Time Complexity : O(N) where N os number of elements given
// Space Complexity : O(N) due to hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
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
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;

        map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, inorder, 0, inorder.length -1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        //base
        if(start > end) return null;
        //logic
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);

        root.left = helper(preorder, inorder, start, rootIdx-1);
        root.right = helper(preorder, inorder, rootIdx+1, end);

        return root;
    }
}
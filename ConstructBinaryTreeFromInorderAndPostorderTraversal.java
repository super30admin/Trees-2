// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity : O(n), for the HashMap and the recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// In preorder: root -> left -> right
// In inorder: left -> root -> right
// We use a HashMap to store the index of each value in the inorder array for O(1) lookup.
// A global index (`idx`) is used to traverse postorder from end to start.
// The recursion follows:
// 1. Take the current postorder value as the root.
// 2. Find its index in inorder using the map.
// 3. Recursively build the right subtree first, then the left subtree, because postorder is being processed from the end

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
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.map = new HashMap<>();

        int postLen = postorder.length;
        this.idx = postLen-1;

        //Populate map
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }

        return helper(postorder,0,postLen-1);
    }

    private TreeNode helper(int[] postorder, int start, int end){
        //bc
        if(start > end) return null;

        //get root value
        int rootVal = postorder[idx];
        idx--;

        //Get index
        int rootIdx = map.get(rootVal);

        //Create root
        TreeNode root = new TreeNode(rootVal);

        //Populate the babies
        root.right = helper(postorder,rootIdx+1,end);
        root.left = helper(postorder, start, rootIdx-1);

        return root;

    }
}
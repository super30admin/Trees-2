// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
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

    Map<Integer, Integer> map;
    int[] inorder;
    int[] postorder;
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        this.map = new HashMap<>();
        this.inorder = inorder;
        this.postorder = postorder;
        this.idx = postorder.length - 1;

        // we will store all the inorder values index because anything on left of root will fall on left subtree and anything on right will fall on right subtree
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(0, inorder.length - 1);
    }

    public TreeNode helper(int left, int right) {

        if(left > right)
            return null;

        //since postorder = left-right-root. last element of the postorder array will be the root
        int val = postorder[idx--];
        TreeNode t = new TreeNode(val);

        //we need to get index of root value from inorder array
        int mid = map.get(val);

        //we create right subtree, because next value in postorder should fall on right subtree
        t.right = helper(mid + 1, right);

        //we create left subtree after all the value on the right subtree are explored.
        t.left = helper(left, mid - 1);
        return t;

    }
}
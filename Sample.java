// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    int idx;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length - 1;
        this.map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(0, inorder.length-1, postorder);
    }
    private TreeNode helper(int start, int end, int[] postorder){
        if(start>end) return null;
        int rootval = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootval);
        int rootIdx = map.get(rootval);
        root.right = helper(rootIdx+1, end, postorder);
        root. left = helper(start, rootIdx-1, postorder);
        return root;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution{
    public int sumNumbers(TreeNode root){
        return helper(root, 0);
    }
    public int helper(TreeNode root, int currNum){
        if(root == null) return 0;
        currNum = currNum*10 + root.val;
        int left = helper(root.left, currNum);
        int right = helper(root.right, currNum);
        if(root.left == null && root.right == null){
            return currNum;
        }
        return left + right;
    }
}
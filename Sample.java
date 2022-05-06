// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
    //TC O(n) SC O(n)
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        
        helper(root, 0);
        
        return sum;
    }
    private void helper(TreeNode root, int currsum){
        if(root == null) return;
        if(root.left == null && root.right == null){
            sum = sum + currsum*10 + root.val;
            return;
        }
        helper(root.left, currsum*10 + root.val);
        helper(root.right, currsum*10 + root.val);
        
    }
}


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
    //TC O(n) SC O(n)
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0) return null;
        idx = postorder.length-1;
        map = new HashMap<>();
        for(int i =0; i< inorder.length;i++){
            map.put(inorder[i],i);
        }
       return helper(postorder , 0, postorder.length-1);
    }
    
    private TreeNode helper(int[]postorder,int start,int end){
        //base case
        if(start>end) return null;
        //logic
        if(idx<0) return null;
        int rootval = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootval);
        int rootidx = map.get(rootval);
        
        
        
        root.right = helper(postorder, rootidx+1, end);
        root.left = helper(postorder, start, rootidx-1);
        
        
        
        
        return root;
        
    }
}

// Time Complexity : O(N) - N is the number of nodes in the tree
// Space Complexity : O(N) - As we use a HashMap as an additional data structure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
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
    int postindex;
    int[] inorder;
    int[] postorder;
    HashMap<Integer,Integer> map1 = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        for(int i = 0;i < inorder.length;i++){
            map1.put(inorder[i],i);
        }
        this.postindex = this.postorder.length - 1;
        return helper(0,this.inorder.length - 1);
    }
    
    public TreeNode helper(int left,int right){
        if(left > right) return null;
        int root_val = this.postorder[postindex--];
        int index = map1.get(root_val);
        TreeNode root = new TreeNode(root_val);
        root.right = helper(index + 1,right);
        root.left = helper(left,index - 1);
        return root;
        
    }
}

// Your code here along with comments explaining your approach
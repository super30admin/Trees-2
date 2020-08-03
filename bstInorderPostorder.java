/**
 * Time complexity: O(n) we are traversing each node given in the postorder traversal
 * Space Complexity: O(n) where n is the number of elements in the postorder traversal array
 * Executed on leetcode: yes
 */

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
    int po_idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0 && inorder.length==0) return null;
        map = new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;++i) //store inorder elements alongwith their indices in hashmap so tht we can retrieve these in O(1) to split the tree into left and right subtrees
        {
            map.put(inorder[i],i);
        }
        po_idx = postorder.length-1; //in post order, last element is the root node
        return helper(inorder,postorder,0,po_idx);
    }
    private TreeNode helper(int[] inorder, int[] postorder,int start,int end)
    {
        if(start>end) return null; //start will always be less than end in case of inorder traversal
        TreeNode root = new TreeNode(postorder[po_idx]);
        int root_idx = map.get(root.val);
        po_idx--;
        root.right = helper(inorder,postorder,root_idx+1,end); // we are creating a left subtree based on inorder traversal and location of root index
        root.left = helper(inorder,postorder,start,root_idx-1); // we are creating a right subtree based on inorder traversal and location of root index
        return root;
    }
}
// Time Complexity : O(n)
// Space Complexity : O(2n) => O(n)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
/*
Instead of having extra arrays space and 4 pointers, reduce it to 3 pointers of inStart, inEnd and postIndex.
And reduce the search complexity of inorder index to O(1) using HashMap. Start traversing the postIndex pointer from the right of the postorder array.
The elements after the index goes to the right binary substructure and below that goes to the left binary substructure.
The base condition would be if the index reaches beyond their limit i.e. start is greater than end, then it is a null value.
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
    private HashMap<Integer,Integer> map = new HashMap<>();
    private int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0 || postorder == null) return null;
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        postIndex = postorder.length-1;
        return binaryTree(inorder,postorder,0,inorder.length-1);
    }
    
    public TreeNode binaryTree(int[] inorder,int[] postorder,int inStart,int inEnd){
        if(inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postIndex]);
        postIndex--;
        int index = map.get(root.val);
        root.right = binaryTree(inorder,postorder,index+1,inEnd);
        root.left = binaryTree(inorder,postorder,inStart,index-1);
        
        return root;
    }
}

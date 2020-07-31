/**
Problem : Construct a binary tree given inorder and postoder traversal.
Did it run on leetcode : yes

Time Complexity : O(n^2), for brute force, and O(n) for optimal solution where n is the number of nodes in the tree
Space Complexity : For brute force solution, O(n^2), and for optimal solution O(1), where n is the number of nodes in the tree.

Approach: 2 pointers
1. We know that root lies in the last position in postorder traversal.
2. We place the elements of inorder array in the hashmap and then get the corresponding position of the root from it.
3. Once we get that, as we already know that elements to the left of root form left subtree, and right of root form right subtree, we recursively build the left and right subtrees by using the start and end pointers.
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
    int postRootIndex;
    HashMap<Integer, Integer> hm ;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        hm = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i],i);
        }
        postRootIndex = postorder.length-1;
        //System.out.println(postRootIndex);
        return getTree(inorder, postorder, 0, inorder.length-1);
    }
    public TreeNode getTree(int[] inorder, int[] postorder, int start, int end) {
        if(postRootIndex < 0 || start > end) {
            return null;
        }
        int inRootIndex = hm.get(postorder[postRootIndex]);
        TreeNode root = new TreeNode(postorder[postRootIndex]);
        postRootIndex--;
        root.right = getTree(inorder, postorder, inRootIndex+1, end);
        root.left = getTree(inorder, postorder, start, inRootIndex - 1);
        return root;
    }
}
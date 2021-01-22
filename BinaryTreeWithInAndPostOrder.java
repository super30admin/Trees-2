// Time Complexity : O(n)
// Space Complexity : O(n);  O(n) For the map + O(n) for build func as well. 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Going from right to left in postorder array, each element is a root. So we start our index at postorder.length -1
//We maintain a map for inorder indexes for quick lookup <Value - Index>
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

    int index;
    HashMap<Integer, Integer> inorderIndexMap = new HashMap();
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(inorder == null || inorder.length == 0) return null;
        index = postorder.length - 1;
        for(int i = 0; i < inorder.length; i++) {

            inorderIndexMap.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length -1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int low, int high) {

        if(low > high) return null;

        int rootIndex = inorderIndexMap.get(postorder[index]); //3
        TreeNode root = new TreeNode(postorder[index]); //20
        index--; //2
        root.right = build(inorder, postorder, rootIndex+1, high); //2
        root.left = build(inorder, postorder, low, rootIndex-1);

        return root;
    }
}

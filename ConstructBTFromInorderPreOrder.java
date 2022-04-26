//Approach 1

class Solution {

    // Time Complexity : 0(n^2)
// Space Complexity :0(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0){
            return null;
        }
        int RootValue = preorder[0];
        TreeNode root = new TreeNode(RootValue);
        int RootIndex = -1;
        for(int i = 0; i < inorder.length; i++){
            if(RootValue == inorder[i]){
                RootIndex = i;
                break;
            }
        }
        int [] inleft = Arrays.copyOfRange(inorder, 0 , RootIndex);
        int [] inright = Arrays.copyOfRange(inorder , RootIndex + 1, inorder.length);
        int [] preleft = Arrays.copyOfRange(preorder, 1 , RootIndex + 1 );
        int [] preright = Arrays.copyOfRange(preorder , RootIndex + 1, preorder.length);

        root.left = buildTree(preleft, inleft);
        root.right = buildTree(preright, inright);
        return root;
    }
}

//Approach 2 reducing time and space

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


    // Time Complexity : 0(n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

    HashMap <Integer, Integer> map;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0){
            return null;
        }
        map = new HashMap<>();
        for(int i= 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0 , preorder.length-1);
    }
    public TreeNode helper(int[] preorder, int start, int end){
        if(start > end){
            return null;
        }
        int RootValue = preorder[index];
        index++;
        TreeNode root = new TreeNode(RootValue);
        int RootIndex = map.get(RootValue);
        root.left = helper(preorder, start, RootIndex - 1);
        root.right = helper(preorder, RootIndex + 1, end);
        return root;
    }
}
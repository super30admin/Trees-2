// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approac

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
    int i=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i = postorder.length-1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, map, 0,inorder.length-1);
        
    }
    public TreeNode helper(int[] inorder, int[] postorder, HashMap<Integer, Integer> map, int start, int end){
        if(start>end) return null;

        int rootVal = postorder[i];
        i--;
        TreeNode root= new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);

        root.right= helper(inorder, postorder, map, rootIdx+1, end);
        root.left = helper(inorder, postorder, map, start, rootIdx-1);
        return root;
    }
}


// Time complexity - O(n*h) and space complexity O(n*h) for linear search and copyOfRange
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
// class Solution {
//     public TreeNode buildTree(int[] inorder, int[] postorder) {
//         if(postorder.length==0) return null;

//         int rootVal = postorder[postorder.length-1];
//         TreeNode root = new TreeNode(rootVal);
//         int idx = -1;
//         for(int i=0; i<inorder.length; i++){
//             if(inorder[i]==rootVal){
//                 idx = i;
//             }
//         }
//         System.out.println(idx);
//         int[] inLeft = Arrays.copyOfRange(inorder, 0, idx);
//         int[] inRight = Arrays.copyOfRange(inorder, idx+1, inorder.length);
//         int[] postLeft = Arrays.copyOfRange(postorder, 0, inLeft.length);
//         int[] postRight = Arrays.copyOfRange(postorder, postLeft.length, postorder.length-1);

//         root.left = buildTree(inLeft, postLeft);
//         root.right = buildTree(inRight, postRight);
//         return root;
//     }
// }
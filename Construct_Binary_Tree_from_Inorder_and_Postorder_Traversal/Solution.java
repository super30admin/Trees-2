// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * postorderarray gives us root node in each level as last element of array. 
 * Inorder array gives us left and right subtree for each level.
 * In each iteration, we make root node from last element of postorder and search that element in inorder array.
 * to form left and right subtree and move ahead. Since we have postorder array, we will construct right subtree and then left subtree for each node
 * We use class variable int idx to keep a track of current element of postorder array to form root node and hashmap to make lookup in constant time.
 * In our helper function, whenever start becomes greater than end, this is the case where we return null as we have reach leaf node.
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
    int idx;
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0)return null;
        
        map = new HashMap<Integer, Integer>();
        idx = postorder.length - 1;
        
        for(int i = 0; i < inorder.length;i++){
            map.put(inorder[i], i);
        }
        
        
//         TreeNode root = new TreeNode(postorder[postorder.length - 1]);
//         int rootIdx = -1;
        
//         for(int i = 0; i < inorder.length;i++){
//             if(root.val == inorder[i]){
//                 rootIdx = i;
//                 break;
//             }
//         }
        
//         int[] inorderleft = Arrays.copyOfRange(inorder, 0, rootIdx);
//         int[] inorderright = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
//         int[] postorderright = Arrays.copyOfRange(postorder, rootIdx, postorder.length - 1);
//         int[] postorderleft = Arrays.copyOfRange(postorder, 0, rootIdx);
       
//         root.right = buildTree(inorderright, postorderright);
//         root.left = buildTree(inorderleft, postorderleft);
       
        
//         return root;
        
        return helper(postorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] postorder, int start, int end){
        //base case
        if(start > end){
            return null;
        }
        
        //logic
        TreeNode root = new TreeNode(postorder[idx]);
        idx--;
        int rootIdx = map.get(root.val);
        root.right = helper(postorder, rootIdx + 1, end);
        root.left = helper(postorder, start, rootIdx - 1);
        
        return root;
    }
}
//TC: O(n)
//SC: O(n)
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
    Map<Integer, Integer> inorderMap;
    int postIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        inorderMap = new HashMap<>();
        int n = postorder.length;
        postIdx = n-1;
        for(int i=0; i<n; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return helper(inorder, postorder, 0, n-1);
        
        
//         int n = postorder.length;
//         int rootVal = postorder[n-1];
//         TreeNode root = new TreeNode(rootVal);
        
//         int rootIdx = 0;
//         for(int i=0; i<inorder.length; i++) {
//             if(inorder[i] == rootVal) {
//                 rootIdx = i;
//             }
//         }
        
//         int[] posLeft = Arrays.copyOfRange(postorder, 0, rootIdx);
//         int[] posRight = Arrays.copyOfRange(postorder, rootIdx, n-1);
//         int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);//end index is ignored
//         int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, n);
        
//         root.left = buildTree(inLeft, posLeft);
//         root.right = buildTree(inRight, posRight);
        
//         return root;
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int start, int end) {
        
        if(start > end) return null;
        
        int rootVal = postorder[postIdx];
        postIdx--;
        TreeNode root = new TreeNode(rootVal);
        
        int rootIdx = inorderMap.get(rootVal);       
        
        root.right = helper(inorder, postorder, rootIdx+1, end);
        root.left = helper(inorder, postorder, start, rootIdx-1);
        
        return root;
    }
}
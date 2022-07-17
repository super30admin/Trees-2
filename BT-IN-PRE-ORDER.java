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
    HashMap<Integer, Integer> hm = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        
        //Optimized 
        // TC: O(N)
        // SC: O(N) 
        for(int i=0;i<inorder.length;i++) {
            hm.put(inorder[i], i);
        }
        
        return helper(preorder, 0, preorder.length-1, inorder, 0, preorder.length-1);
        
        
        
        
        // TC: O(N**2)
        // SC: O(N**2) - N nodes will have n arrays
        
        
//         int rootIdx = -1;
//         int rootVal = preorder[0];
//         TreeNode root = new TreeNode(rootVal);
        
//         for(int i=0;i<inorder.length;i++) {
//             if(inorder[i] == rootVal) {
//                 rootIdx = i;
//                 break;
//             }
//         }
        
//         int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
//         int[] inorderRight = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);
//         int[] preorderLeft =  Arrays.copyOfRange(preorder, 1, rootIdx+1);
//         int[] preorderRight = Arrays.copyOfRange(preorder, rootIdx+1, preorder.length);
        
//         root.left = buildTree(preorderLeft, inorderLeft);
//         root.right = buildTree(preorderRight, inorderRight);
        
//         return root;
        
        
    }
    
    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        //base case 
        if(preStart > preEnd || inStart > inEnd) return null;
        
        //logic 
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = hm.get(root.val);
        int numsleft = rootIndex - inStart;
        
        
        root.left =  helper(preorder, preStart+1, preStart+numsleft, inorder, inStart, rootIndex - 1);
        root.right =  helper(preorder, preStart+numsleft+1, preEnd, inorder, rootIndex + 1, inEnd);
            
        
        return root;
    }
}

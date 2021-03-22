// Time Complexity : O(n) 
// Space Complexity : O(n) asymptotically [O(n+h)]
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
    private HashMap<Integer, Integer> hashMap;
    private int postIndex;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length == 0)
            return null;
        if(inorder == null || inorder.length == 0)
            return null;
        
        //for indexing in inorder root in O(1)
        hashMap = new HashMap<>();
        postIndex = postorder.length-1;
        
        for(int x= 0; x<inorder.length;x++){
            hashMap.put(inorder[x], x);
        }
        
        return buildSubTree(inorder, postorder, 0, inorder.length-1);
    }
    
    private TreeNode buildSubTree(int[] inorder, int[] postorder, int inStart, int inEnd){
        if(inStart > inEnd){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postIndex]);
        postIndex--;
        
        //Root -> Right ->Left
        
        int index = hashMap.get(root.val);
        
        root.right = buildSubTree(inorder, postorder, index + 1, inEnd);
        root.left = buildSubTree(inorder, postorder, inStart, index - 1);
        return root;
    }
}


// Your code here along with comments explaining your approach





// Time Complexity : O(n) asymptotically
// Space Complexity : O(n) asymptotically
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length == 0)
            return null;
        if(inorder == null || inorder.length == 0)
            return null;
        
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        
        int index = -1;
        
        //find root in inorder to separate LST and RST
        for(int i = 0;i<inorder.length;i++){
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }
        
        //Preorder
        int[] postLeft = Arrays.copyOfRange(postorder, 0, index);
        int[] postRight = Arrays.copyOfRange(postorder, index, postorder.length-1);
        
        //Inorder
        int[] inLeft = Arrays.copyOfRange(inorder,0,index);
        int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        
        root.left = buildTree(inLeft,postLeft);
        root.right = buildTree(inRight,postRight);
        
        return root;
    }
}

*/
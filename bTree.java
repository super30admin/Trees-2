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
    HashMap<Integer,Integer> hmap = new HashMap<>();
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder.length == 0)
            return null;
        idx = postorder.length -1;
        for(int i = 0;i<inorder.length;i++){
            hmap.put(inorder[i],i);
        }
        
        return helper(inorder,postorder,0,inorder.length -1);
    }
    
    public TreeNode helper(int[] inorder,int[] postorder,int start,int end){
        
        if(start>end)
            return null;
        int rootVal = postorder[idx];
        TreeNode root = new TreeNode(rootVal);
        int rIdx = hmap.get(rootVal); //rootIndex in the inorder array
        idx--;
        root.right = helper(inorder,postorder,rIdx+1,end);
        root.left = helper(inorder,postorder,start,rIdx-1);
        
        return root;
    }
        
}

//Time Complexity: O(n)
//Space Complexity: O(2n) for the hashmap and recursive stack

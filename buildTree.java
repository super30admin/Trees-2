// TC - O(n);
// SC - O(n);

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
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length-1;
        int len = inorder.length;
        map = new HashMap<>();
        
        for(int i=0;i<len;i++){
            map.put(inorder[i],i);
        }
        
        return helper(postorder,0,len-1);
        
        
    }
    
    private TreeNode helper(int[] postorder,int s, int e){
        
        //Base
        if(s>e) return null;
        //Logic
        int rootVal = postorder[index--];
        //index--;
        TreeNode root = new TreeNode(rootVal);
        
        int rootIn = map.get(rootVal);
        
        root.right = helper(postorder,rootIn+1,e);       
        root.left = helper(postorder,s,rootIn-1);
        
        return root;
        
    }
}

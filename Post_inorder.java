//TC - O(n)
//SC - O(n)
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
        HashMap<Integer,Integer> map = new HashMap<>();
        int idx = postorder.length-1;
        for(int  i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
       return contructTree(inorder,postorder,0,inorder.length-1,map,idx);
    }
    
    public TreeNode contructTree(int[] inorder,int[] postorder,int start,int end, HashMap<Integer,Integer> map,int idx){
        
        if(start>end || idx<0) return null;
        
        TreeNode root = new TreeNode(postorder[idx]);
        int curr = map.get(root.val);
        
        root.left = contructTree(inorder,postorder,start,curr-1,map,idx-(end-curr+1));
        root.right = contructTree(inorder,postorder,curr+1,end,map,idx-1);
                
        return root;
    }
}
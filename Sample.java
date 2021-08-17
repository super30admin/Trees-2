// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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
        if(inorder.length==0|| inorder==null){
            return null;
        }
        HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            hash.put(inorder[i],i);
        }
        TreeNode root=new TreeNode(postorder[postorder.length-1]);
        int index=hash.get(root.val);
       
        int[] inorder_left=Arrays.copyOfRange(inorder,0,index);
        int[] inorder_right=Arrays.copyOfRange(inorder,index+1,inorder.length);
        int[] postorder_left=Arrays.copyOfRange(postorder,0,index);
        int[] postorder_right=Arrays.copyOfRange(postorder,index,postorder.length-1);
        
        root.left=buildTree(inorder_left,postorder_left);
        root.right=buildTree(inorder_right,postorder_right);
        return root;
        
         
        
    }
}






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
    int total=0;
    public int sumNumbers(TreeNode root) {
        sum_leaves(root,0);
        return total;
        
    }
    public void sum_leaves(TreeNode root,int sum){
        if(root==null){
            return;
        }
        if(root.left==null && root.right ==null){
            sum=sum*10+root.val;
            total+=sum;
            return;
        }
        if(root.left!=null){
            
            sum_leaves(root.left,(sum*10)+root.val);
        }
        if(root.right!=null){
            sum_leaves(root.right,(sum*10)+root.val);
        }
    }
}



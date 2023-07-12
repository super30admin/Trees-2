// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


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
    public int sumNumbers(TreeNode root) {
        List<String> list=new ArrayList<String>();
        list=inorder(root,list,"");
        int sum=0;
        System.out.println(list);
        for(String a:list){
            sum+=Integer.parseInt(a);
        }
        return sum;
    } 
    public List<String> inorder(TreeNode root,List<String> list,String str){
        if(root==null){
            return list;
        }
        str=str+root.val;
        if(root.left==null && root.right==null){
            list.add(str);
        }
        inorder(root.left,list,str);
        inorder(root.right,list,str);
        return list;
    }
    
}
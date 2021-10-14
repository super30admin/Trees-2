//Time complexity:-o(n)
//space complexity:-o(1)
//Did this code run on leetcode:- Yes.
//What problems did you face while coding:- while building concatination of integers tried using string concatination.
// yur code with explanation:- basic idea is a number is shifted toleftside by multiplying 10 with and present root value is 
// added as unit's place and reccursion is done to both left and right sides.






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
    private int sum=0;
    public int sumNumbers(TreeNode root) {
  
        if(root==null){
            return sum;
        }
        getsum(root,0);
    return sum;
    }


    private void getsum(TreeNode root,int current){
        if(root==null){
            return;
    }
        current=current*10+root.val;
        if((root.left==null)&&(root.right==null)){
            sum=sum+current;
            return;
    }
        getsum(root.left,current);
        getsum(root.right,current);
    
}
}
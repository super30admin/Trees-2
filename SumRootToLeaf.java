/**
 * The time complexity is O(N) and the space complexity in the worst case is O(N) if we count the stack space and the tree is skewed to one side
 * The solution traverses to the leaf by including all the nodes in between and adding to the total
 *
 * The solution passed all the test cases in leetcode.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        return calculateSum(root,0,0);
    }

    public int calculateSum(TreeNode root,int currsum,int total){

        if(root.left==null && root.right==null){
            currsum = currsum+root.val;
            total = total + currsum;
            return total;
        }

        currsum = currsum+root.val; currsum = currsum*10;

        if(root.left!=null){
            total = calculateSum(root.left,currsum,total);
        }
        if(root.right!=null){
            total = calculateSum(root.right,currsum,total);
        }

        return total;
    }

}
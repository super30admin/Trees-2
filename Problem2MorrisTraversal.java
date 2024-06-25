// ## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A

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


 // Morris pre-order traversal
 class Solution {
    public int sumNumbers(TreeNode root) {
        int totalSum = 0;
        int currSum = 0;
        int steps; // to backtrack sum

        TreeNode curr=root;
        while(curr!=null){
            // check if leftmost node
            if(curr.left==null){
                //process and move ahead
                currSum = currSum*10 + curr.val;
                if(curr.right==null){
                    totalSum+=currSum;
                }
                curr=curr.right;
            }else{
                //find rightmost in left sub-tree and link to curr
                TreeNode rightMost = curr.left;
                steps=1;
                while(rightMost.right!=null && rightMost.right!=curr){
                    rightMost = rightMost.right;
                    steps++;
                }

                //if already linked
                if(rightMost.right==curr){
                    // left sub-tree already processed
                    // remove link and move ahead
                    // add to totalsum, backtrack sum
                    if(rightMost.left==null){
                        totalSum += currSum;
                    }
                    for(int i=0;i<steps;i++){
                        currSum = currSum/10;
                    }
                    rightMost.right=null;
                    curr=curr.right;
                }else{
                    // link and process curr node, move on to left subtree
                    currSum = currSum*10 + curr.val;
                    rightMost.right=curr;
                    curr=curr.left;
                }
            }
        }
        return totalSum;
    }
}
// Time complexity:- O(n)
// Space complexity:- O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 
/**
 * Approach: 
 * This problem is about calculating the total sum of all numbers formed by root-to-leaf paths in a binary tree.
 * I used a depth-first search (DFS) recursive approach, where at each node we build the current number by shifting the 
 * digits (multiplying by 10) and adding the current node’s value. When a leaf node is reached, the formed number is added
 * to the total sum; the recursion continues for all paths until the final total is returned.
 */
class Solution {
    int totalSum;
    public int sumNumbers(TreeNode root) {
        totalSum = 0;
        helper(root,0);

        return totalSum;
        
    }
    public void helper(TreeNode node, int sum) {

        //base condition
        if(node == null) {
            return;
        }
        // process: 
        // build the number by shifting digits left and adding current node value 
        sum = sum * 10 + node.val;
        
        // if it's a leaf node, add the current number to the total sum
        if(node.left == null && node.right == null) {
            totalSum = totalSum + sum;
        }

        //recurse
        helper(node.left, sum);
        helper(node.right,sum);
    }
}


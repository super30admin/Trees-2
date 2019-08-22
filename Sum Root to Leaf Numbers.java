/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Recursive Solution: DFS Solution (Pre-order Traversal)
// Bests 100% of LeetCode Submissions


class Solution {
    public int sumNumbers(TreeNode root) {
        
        return getSum(root, 0);
    }
    
    public int getSum(TreeNode root, int sum){
        
        if(root == null)  return 0;
        
        if (root.right == null && root.left == null) return sum * 10 + root.val;
        
        return getSum(root.left, sum * 10 + root.val) + getSum(root.right, sum * 10 + root.val);
    }
}


// Iterative Solution using two stacks

// Faster than just 32% of LeetCode Submissions
// T: O(n)
// S: O(n)

/**
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
        
        if(root == null)    return 0;
        
        Stack<TreeNode> nodeList = new Stack<TreeNode>();
        Stack<Integer> sumList = new Stack<Integer>();
        
        nodeList.push(root);
        sumList.push(root.val);
        
        int total = 0;
        
        while(!nodeList.isEmpty()){
            
            root = nodeList.pop();
            int curSum = sumList.pop();
        
            
            if(root.left == null && root.right == null){
                total += curSum;
            }
            
             if(root.right != null){

                nodeList.push(root.right);
                sumList.push(curSum * 10 + root.right.val);
            }
            
                
            if(root.left != null){

                nodeList.push(root.left);
                sumList.push(curSum * 10 + root.left.val);
            }
                
           
        }
        
        return total;
    }
}
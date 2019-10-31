/**Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]

1
/ \

2 3 Output: 25 Explanation:

The root-to-leaf path 1->2 represents the number 12.

The root-to-leaf path 1->3 represents the number 13.

Therefore, sum = 12 + 13 = 25. Example 2:

Input: [4,9,0,5,1]

4
/ \

9 0

/ \

5 1 Output: 1026 Explanation:

The root-to-leaf path 4->9->5 represents the number 495.

The root-to-leaf path 4->9->1 represents the number 491.

The root-to-leaf path 4->0 represents the number 40.

Therefore, sum = 495 + 491 + 40 = 1026.
 */

// Time Complexity : O(n) (as processing is done on each node only once)
// Space Complexity : O(edge) or O(n) (height of tree) (it can never happen more than the height of the tree)
// Did this code successfully run on Leetcode : Yes(accepted)
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//First start with Recursive solution. We will follow BFS approach,
//because we have to cover/visit each nodes simultaneously at each level
//while in DFS, if the leaf node reaches null child(left), recursion will stop and it won't visit right chill of that node
class Solution{ 
    public int sumNumbers(TreeNode root){
        return helper(root, 0);
    }

    public int helper(TreeNode node, int value){
        //base case: 1. if root is null, return 0
        //2. if left and right child of leaf node is null, return the leaf node value
        if(node == null) return 0;
        if(node.left == null && node.right == null) return value*10 + node.val;
        return helper(node.left, value*10 + node.val) + helper(node.right, value*10 + node.val);
    }
}
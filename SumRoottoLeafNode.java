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
/*
* Approach: 
- As we have to traverse from leaf to root, we do depth first search.(in, pre, post all should work)
- We keep track of the currVal at all times on each root hence it should be passed as a parameter to the recursive stack
- Once we hit the leaf node, i.e. left and right of that note is null, we add the currVal to the result
We can do it using three techniques:
1. void based recursion - bruteforce
2.  void based conditional recursion
3. int based conditional recursion -> to avoid using global parameter as it is not recommended in prod systems
*/

//Approach: 2
//TC: O(n) -> iterating through all the nodes
// SC:O(h) -> recursive stack at max h nodes -> worst case O(n)
class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        this.result = 0;
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int currVal){
        //base
        if(root == null) return;

        //logic

        currVal = currVal * 10 + root.val;
        if(root.left == null && root.right == null){
            result = result + currVal;
            return;
        }
        
        helper(root.left, currVal);
        helper(root.right, currVal);
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

// Approach 3 -> int based recursion
//TC: O(n) -> iterating through all the nodes
// SC:O(h) -> recursive stack at max h nodes -> worst case O(n)
class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int currVal){
        //base
        if(root == null)
            return 0;

        //logic

        currVal = currVal * 10 + root.val;
        if(root.left == null && root.right == null)
            return currVal;
        int l = helper(root.left, currVal);
        int r = helper(root.right, currVal);

        return l + r;

    }
}
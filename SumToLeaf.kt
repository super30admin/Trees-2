// In this problem we use inorder traversal to calculate the sum from root to leaf nodes.
// Time Complexity : O(N) where N is the number of nodes
// Space Complexity : O(H) where H is the height of the tree

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
   var result = 0
    fun sumNumbers(root: TreeNode?): Int {
        helper(root, 0)
        return result
    }

    fun helper(root:TreeNode?, currNum: Int) {
        if(root == null) return

        val newNum = currNum * 10 + root.`val`

        helper(root.left, newNum)

        if(root.left == null && root.right == null){
           result += newNum;
        }

        helper(root.right, newNum)
    }
}
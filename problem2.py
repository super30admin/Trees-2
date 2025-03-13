'''
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        result = 0

        def findSum(node, cur_sum):
            nonlocal result
            if not node: return

            cur_sum = cur_sum * 10 + node.val
            if not (node.left or node.right):
                result += cur_sum
            findSum(node.left, cur_sum)
            findSum(node.right, cur_sum)

        findSum(root, 0)
        
        return result
# Time Complexity : O(n)
# Space Complexity : O(height of tree)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 
# Your code here along with comments explaining your approach
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        def helper(node, curr_sum):
            nonlocal total_sum
            if node:
                curr_sum = curr_sum*10 + node.val
                if not (node.left or node.right):
                    total_sum += curr_sum
                helper(node.left, curr_sum)
                helper(node.right, curr_sum)     
        total_sum = 0
        helper(root, 0)
        return total_sum 

#Time Complexity: O(n) Each Node is visited only once
#Space Complexity: O(h) Height of the tree dure recurssive call stack
# Did this problem run in Leetcode: Yes
# Any problem you faced while coding this: No
# # Your code here along with comments explaining your approach
# DFS tp traverse the tree and current_sum accumulates value along each root-to-leaf path
# When a leaf node is reached, it returns the current_sum.

# Definition for a binary tree node.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def dfs(node, current_sum):
            if not node: # If node element is empty or null
                return 0
            current_sum = current_sum * 10 + node.val # Build the number 
            if not node.left and not node.right: # If root node doesn't have any child
                return current_sum
            
            left_sum = dfs(node.left, current_sum) 
            right_sum = dfs(node.right, current_sum)
            return left_sum + right_sum
        return dfs(root, 0)
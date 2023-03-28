# Definition for a binary tree node.
from typing import List
class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

# Time Complexity : O(n)
# Space Complexity : O(h)

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        total_sum = 0
        
        def dfs(node, curr_sum):
            nonlocal total_sum
            
            if not node:
                return
            
            curr_sum = (curr_sum * 10) + node.val
            
            if not node.left and not node.right:
                total_sum += curr_sum
                return
            
            dfs(node.left, curr_sum)
            dfs(node.right, curr_sum)
        
        dfs(root, 0)
        return total_sum
"""
TC: O(N) {we iterate over each element only once}
SC: O(N) {if we consider recursion stack as a memory or  O(1) if we don't}

Approach:

We start with creating a void helper function and initializing a global variable called result. The helper function basically updates
the current sum that it gets from its parameter from the parent node. Then it checks if the node is a leaf, if it is then it updates the result
with the curr val (uptil that node which is also the curr value at that node since we update the curr at everynode).

In the end, return the global result.

The problem ran successfully on Leetcode.
"""

# Definition for a binary tree node.
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def helper(self, node, curr):
        if not node:
            return
        
        curr = curr*10 + node.val
        
        if not node.left and not node.right:
            self.result += curr
            return
        
        self.helper(node.left, curr)
        self.helper(node.right, curr)
        


    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.result = 0
        self.helper(root, 0)
        return self.result
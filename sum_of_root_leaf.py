"""
time - o(n)
space - o(n)
go from root to leaf at every level multiply by 10 and add final value to glocal result variable only when leaf node is reached
"""
from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        self.result = 0
        self.helper(root, 0)
        return self.result

    def helper(self, root, sumSoFar):
        if not root:
            return
        if not (root.left or root.right):
            self.result += (sumSoFar + root.val)
            return
        
        sumSoFar += root.val
        self.helper( root.left, sumSoFar*10)
        self.helper( root.right, sumSoFar*10)


        
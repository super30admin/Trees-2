'''
Time Complexity: O(n)
Space Complexity: O(h)
Run on Leetcode: YES
'''
from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    result = 0
    def helper(self, root: Optional[TreeNode], num: int) -> None:
        #base
        num = num * 10 + root.val
        if not (root.left or root.right):
            self.result += num
            return
        #logic
        if root.left:
            self.helper(root.left, num)
        if root.right:
            self.helper(root.right, num)
            
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root, 0)
        return self.result
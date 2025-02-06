# Time complexity - O(n)
# Space complexity - O(h)

# Approach - With helper recursive function that keeps track of the total sum

from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0
        self.sum = 0
        self.helper(root, 0)
        return self.sum
    
    def helper(self, root: Optional[TreeNode], currSum: int) -> None:
        if root == None:
            return
        if root.left == None and root.right == None:
            self.sum += currSum * 10 + root.val
            return
        self.helper(root.left, currSum*10 + root.val)
        self.helper(root.right, currSum*10 + root.val)
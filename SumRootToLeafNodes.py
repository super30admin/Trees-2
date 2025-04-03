# Time Complexity : O(n)
# Space Complexity : O(h) # where h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def helper(root, currentNum):
            if not root:
                return 0
            currentNum = currentNum*10 + root.val
            if not root.left and not root.right:
                return currentNum
            return helper(root.left, currentNum) + helper(root.right, currentNum)
           
        return helper(root, 0)

# // Time Complexity : O(n)
# // Space Complexity : O(h). h = height of the tree
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    sum = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        self.dfs(root, 0)
        return self.sum
        

    def dfs(self, root, num):
        if root is None:
            return
        
        if root.left is None and root.right is None:
            self.sum += (num * 10) + root.val

        self.dfs(root.left, (num * 10 + root.val))
        self.dfs(root.right, (num * 10 + root.val))
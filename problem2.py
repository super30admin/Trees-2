# https://leetcode.com/problems/sum-root-to-leaf-numbers/

# Time Complexity : O(N) is Number of nodes in the tree.
# Space Complexity : O(H) where H is height of the tree, and stack space is used.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach.
# Approach - We start from root and as we go left or right we multiply root value with 10 and add it.
# while we return back we divide the cur result by 10 to get the root value back.

from typing import List, Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    sum: int
    curr: int

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.sum, self.curr = 0, 0
        self.helper(root)
        return self.sum

    def helper(self, root):
        if root is None:
            return
        self.curr = self.curr * 10 + root.val
        if root.left is None and root.right is None:
            self.sum += self.curr

        self.helper(root.left)
        self.helper(root.right)
        self.curr = self.curr // 10

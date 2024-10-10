# Time Complexity = O(n) | Space Complexity = O(h)

from typing import Optional
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right


class Solution:
    result = 0

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root, 0)
        return self.result

    def helper(self, root: Optional[TreeNode], curr_val: int):
        if root is None: return

        curr_val = curr_val * 10 + root.val

        self.helper(root.left, curr_val)

        if root.left is None and root.right is None:  # leaf node
            self.result += curr_val

        self.helper(root.right, curr_val)




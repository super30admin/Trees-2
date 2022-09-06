# Time Complexity : O(n) where n is the number of nodes
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.sum = 0

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.leaf_helper(root, 0)
        return self.sum

    def leaf_helper(self, root: Optional[TreeNode], num_at_root: int):
        if root is None:
            return
        num_at_root = (num_at_root*10)+root.val
        if root.left is None and root.right is None:
            self.sum += num_at_root
        self.leaf_helper(root.left, num_at_root)
        self.leaf_helper(root.right, num_at_root)


class Solution2:

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        return self.leaf_helper(root, 0)

    def leaf_helper(self, root: Optional[TreeNode], num_at_root: int) -> int:
        if root is None:
            return 0
        num_at_root = (num_at_root * 10) + root.val
        if root.left is None and root.right is None:
            return num_at_root
        return self.leaf_helper(root.left, num_at_root) + self.leaf_helper(root.right, num_at_root)

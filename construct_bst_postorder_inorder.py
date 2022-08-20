# Time Complexity : O(n) where n is the number of nodes
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import Optional, List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.inorder_dict = {}
        self.postorder = None
        self.inorder = None
        self._len = 0

    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self._len = len(inorder) - 1
        if self._len == 0:
            return None
        for i, val in enumerate(inorder):
            self.inorder_dict[val] = i
        self.postorder = postorder
        self.inorder = inorder
        return self.tree_builder(0, self._len, self._len, 0)

    def tree_builder(self, in_start: int, in_end: int, post_start: int, post_end: int) -> Optional[TreeNode]:
        if in_start > in_end or post_start < post_end:
            return None
        root_val = self.postorder[post_start]
        _index = self.inorder_dict[root_val]
        root = TreeNode(root_val)
        len_left = _index - in_start
        root.left = self.tree_builder(in_start, _index - 1, post_end + len_left - 1, post_end)
        root.right = self.tree_builder(_index + 1, in_end, post_start - 1, post_end + len_left)
        return root

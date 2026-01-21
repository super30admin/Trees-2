
"""
time - 0(n)
space - o(n)
"""
from typing import List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        self.postorder_index = len(postorder)-1
        self.postorder = postorder
        # build a hashmap to store index and value for inorder list
        self.inorder_index_map = {}
        for index, value in enumerate(inorder):
            self.inorder_index_map[value] = index

        return self.helper(0, len(inorder) - 1)

    def helper(self, in_left, in_right):
        if in_left > in_right:
            return None

        # last element as a root
        val = self.postorder[self.postorder_index]
        self.postorder_index-=1
        root = TreeNode(val)

        index = self.inorder_index_map[val]

        # build subtree
        root.right = self.helper(index + 1, in_right)
        root.left = self.helper(in_left, index - 1)
        return root
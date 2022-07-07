'''
Time Complexity: O(n)
Space Complexity: O(n)
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
    postIndex = 0
    nodeMap = {}
    def helper(self, postorder: list[int], start: int, end: int) -> Optional[TreeNode]:
        if end < start:
            return None
        idx = self.nodeMap[postorder[self.postIndex]]
        root = TreeNode(postorder[self.postIndex])
        self.postIndex -= 1
        root.right = self.helper(postorder, idx + 1, end)
        root.left = self.helper(postorder, start, idx - 1)
        return root
    
    def buildTree(self, inorder: list[int], postorder: list[int]) -> Optional[TreeNode]:
        # null
        if len(postorder) == 0:
            return None
        self.postIndex = len(postorder) - 1
        for index in range(len(inorder)):
            self.nodeMap[inorder[index]] = index
        return self.helper(postorder, 0, len(inorder) - 1)
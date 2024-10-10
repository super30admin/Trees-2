# Time Complexity = O(n) | Space Complexity = O(n) + O(h) hashmap and stack space

from typing import Optional
#Definition for a binary tree node.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    hash_map = {}
    def buildTree(self, inorder: list[int], postorder :list[int]) -> Optional[TreeNode]:
        # self.idx = len(postorder)-1
        for i in range(len(inorder)):
            self.hash_map[inorder[i]] = i
        return self.helper(postorder, 0, len(inorder ) -1)

    def helper(self, postorder: list[int], start: int, end: int):
        # base case
        if start > end: return None

        root_val = postorder.pop()
        root = TreeNode(root_val)
        root_idx = self.hash_map.get(root_val)

        root.right = self.helper(postorder, root_idx +1, end)
        root.left = self.helper(postorder, start, root_idx -1)

        return root

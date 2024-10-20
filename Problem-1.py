#Complexities
# Postorder will gives the root node at the end . find the index of the root node in inorder.
# left to the inorder is the left tree nad right to the index is right tree .
# traverse untill all the nodes in postoreder is finished

#Complexities
# Time: O(n)
# Space:O(N)



# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from typing import List, Optional


class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.hashMap = {}
        for i in range(len(inorder)):
            self.hashMap[inorder[i]] = i

        self.idx = len(postorder) - 1

        return self.helper(postorder, 0, len(inorder) - 1)

    def helper(self, postorder, start, end):
        if (start > end):
            return None
        root_val = postorder[self.idx]
        self.idx -= 1
        root_index = self.hashMap[root_val]

        root = TreeNode(val=root_val)
        root.right = self.helper(postorder, root_index + 1, end)
        root.left = self.helper(postorder, start, root_index - 1)

        return root


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.inorderIndices = {}
        self.index = 0

    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        n = len(postorder)
        self.index = n-1

        for i in range(n):
            self.inorderIndices[inorder[i]] = i

        return self.buildNode(postorder, 0, n-1)

    def buildNode(self, postorder, start, end):
        # base case
        if start > end or self.index >= len(postorder):
            return None

        # logic
        value = postorder[self.index]
        self.index -= 1
        root = TreeNode(value)
        rootIndex = self.inorderIndices[value]
        root.right = self.buildNode(postorder, rootIndex+1, end)
        root.left = self.buildNode(postorder, start, rootIndex-1)

        return root
        
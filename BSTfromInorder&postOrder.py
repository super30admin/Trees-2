# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time complexity:
# O(N) since one has to visit each node.
#
# Space complexity: up to
# O(H) to keep the recursion stack
class Solution:
    postIdx = 0
    inoderMap = {}

    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.postIdx = len(postorder) - 1
        for idx, val in enumerate(inorder):
            self.inoderMap[val] = idx
        return self.helper(postorder, 0, len(inorder) - 1)

    def helper(self, preorder, leftIdx, rightIdx):

        if leftIdx > rightIdx:
            return None
        root = TreeNode(preorder[self.postIdx])
        self.postIdx -= 1
        root.right = self.helper(preorder, self.inoderMap[root.val] + 1, rightIdx)
        root.left = self.helper(preorder, leftIdx, self.inoderMap[root.val] - 1)
        return root
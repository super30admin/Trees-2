# TimeComplexity: O(n)
# SpaceComplexity: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def __init__(self):
        self.idx = 0
        self.hmap = {}

    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.idx = len(postorder) - 1
        for i in range(len(inorder)):
            if inorder[i] not in self.hmap:
                self.hmap[inorder[i]] = i
        return self.helper(inorder, postorder, 0, len(inorder) - 1)

    def helper(self, inorder: List[int], postorder: List[int], start: int, end: int) -> Optional[TreeNode]:
        if start > end:
            return None

        rootVal = postorder[self.idx]
        self.idx -= 1

        root = TreeNode(rootVal)
        rootIdx = self.hmap[rootVal]

        root.right = self.helper(inorder, postorder, rootIdx + 1, end)
        root.left = self.helper(inorder, postorder, start, rootIdx - 1)

        return root

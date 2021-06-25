
# Time Complexity : O(N)
# Space Complexity : O(N)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def __init__(self):
        self.postOrderIndex = 0
        self.mapper = dict()

    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        for index in range(len(inorder)):
            self.mapper[inorder[index]] = index
        self.postOrderIndex = len(postorder) - 1
        return self.helper(postorder, 0, len(inorder) - 1)

    def helper(self, postorder, start, end):
        # base case
        if start > end:
            return None
        # logic
        rootVal = postorder[self.postOrderIndex]
        root = TreeNode(rootVal)
        self.postOrderIndex -= 1
        rootIndex = self.mapper[rootVal]
        root.right = self.helper(postorder, rootIndex + 1, end)  # left
        root.left = self.helper(postorder, start, rootIndex - 1)  # right
        return root


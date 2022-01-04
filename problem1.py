# Time Complexity : O(n)
# Space Complexity:o(n)
#  Did this code successfully run on Leetcode : Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.idx = 0
        self.map = {}

    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if postorder is None or inorder is None or len(postorder) == 0:
            return None

        self.idx = len(postorder) - 1

        for idx, val in enumerate(inorder):
            self.map[val] = idx

        return self.helper(postorder, 0, len(inorder) - 1)

    def helper(self, postorder, start, end):
        # base case
        if start > end:
            return None

        # logic
        rootVal = postorder[self.idx]
        self.idx -= 1
        print(rootVal)
        root = TreeNode(rootVal)
        rootIndex = self.map[rootVal]
        root.right = self.helper(postorder, rootIndex + 1, end)
        root.left = self.helper(postorder, start, rootIndex - 1)

        return root

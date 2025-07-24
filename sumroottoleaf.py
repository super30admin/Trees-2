# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def helper(self, root, currSum):
        if not root:
            return

        self.helper(root.left, (currSum * 10) + root.val)
        if not root.left and not root.right:
            self.totalsum = self.totalsum + (currSum * 10 + root.val)
            return
        self.helper(root.right, (currSum * 10) + root.val)

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.totalsum = 0
        if not root:
            return 0

        self.helper(root, 0)
        return self.totalsum
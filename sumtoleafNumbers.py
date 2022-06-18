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
    result = 0

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        self.helper(root, 0)
        return self.result

    def helper(self, root, currSum):
        if not root:
            return 0

        self.helper(root.left, ((currSum * 10) + root.val))
        self.helper(root.right, ((currSum * 10) + root.val))
        if root.left == None and root.right == None:
            self.result += ((currSum * 10) + root.val)
        return


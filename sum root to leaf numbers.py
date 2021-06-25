
# Time Complexity : O(N)
# Space Complexity : O(H)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = 0

    def sumNumbers(self, root: TreeNode) -> int:
        if not root: return 0
        self.helper(root, 0)
        return self.result

    def helper(self, root, currentSum):
        if not root:
            return None

        currentSum = currentSum * 10 + root.val

        if not root.right and not root.left:
            self.result = self.result + currentSum

        self.helper(root.left, currentSum)
        self.helper(root.right, currentSum)


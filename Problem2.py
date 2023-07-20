# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # Time Complexity:O(n)
    # Space Complexity:O(h)
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.result = 0
        self.helper(root, 0)
        return self.result

    def helper(self, root, curr):
        if root is None:
            return
        curr = curr * 10 + root.val

        if root.left is None and root.right is None:
            self.result += curr

        self.helper(root.left, curr)
        self.helper(root.right, curr)

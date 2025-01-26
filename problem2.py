# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root is None: return 0
        def dfs(root, value):
            if root.left is None and root.right is None: return value
            if root.left:
                l = dfs(root.left, 10 * value + root.left.val)
            else:
                l = 0
            if root.right:
                r = dfs(root.right, 10 * value + root.right.val)
            else:
                r = 0
            print(l, r)
            return l + r
        return dfs(root, root.val)

# TC = O(n) and SC = O(1)
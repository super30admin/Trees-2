# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:

        def dfs(curr, sum):

            if not curr:
                return 0

            sum = sum * 10 + curr.val

            if not curr.left and not curr.right:
                return sum

            return (dfs(curr.left, sum) + dfs(curr.right, sum))

        return dfs(root, 0)
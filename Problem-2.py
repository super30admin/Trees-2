# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.sum = 0

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.dfs(root, 0)
        return self.sum

    def dfs(self, root, currNum):
        # base case
        if not root:
            return

        # logic
        currNum = currNum*10 + root.val

        if not root.left and not root.right:
            self.sum += currNum
            return

        self.dfs(root.left, currNum)
        self.dfs(root.right, currNum)
        
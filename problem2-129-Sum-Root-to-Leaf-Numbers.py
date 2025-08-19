# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time Complexity : o(n)
#Space Complexity : o(h)
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.sum = 0
        if root == None:
            return 0
        self.helper(root, 0)
        return self.sum

    def helper(self, root: Optional[TreeNode], sum_loc: int) -> None:

        if root == None:
            return

        if root.left == None and root.right == None:
            self.sum = self.sum + sum_loc * 10 + root.val
            return

        self.helper(root.left, sum_loc * 10 + root.val)
        self.helper(root.right, sum_loc * 10 + root.val)




# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    TC: O(n)
    SC: O(max depth)
    """
    result = 0

    def sumHelperFunc(self, root, sum):

        if root == None:
            return

        sum = sum * 10 + root.val

        if root.left == None and root.right == None:
            self.result += sum

        self.sumHelperFunc(root.left, sum)
        self.sumHelperFunc(root.right, sum)

    def sumNumbers(self, root: Optional[TreeNode]) -> int:

        if root == None:
            return 0

        self.sumHelperFunc(root, 0)

        return self.result
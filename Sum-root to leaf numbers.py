'''
Time Complexity:O(n)
Space Complexity:O(n) Height of the tree
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    output = 0

    def sumNumbers(self, root: TreeNode) -> int:
        self.output = 0
        if root == None:
            return self.output

        self.calsum(root, 0)
        return self.output

    def calsum(self, root: TreeNode, currsum):

        if not root:
            return
        currsum = currsum * 10 + root.val
        if not root.left and not root.right:
            self.output += currsum
            return
        self.calsum(root.left, currsum)
        self.calsum(root.right, currsum)
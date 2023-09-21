# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root) -> int:
        if root == None:
            return 0

        def recursion(root, curr):
            if root == None:
                return
            recursion(root.left, curr*10 + root.val)
            if root.left == None and root.right == None:
                self.sum += curr*10 + root.val
            recursion(root.right, curr*10 + root.val)

        self.sum = 0
        recursion(root,0)
        return self.sum
    
#TC: O(n)
#SC: O(h)
            
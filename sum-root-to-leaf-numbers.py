# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    sum = 0
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def helper(root, add):
            # Base
            if not root: 
                return
            if not root.left and not root.right: 
                self.sum += add*10 + root.val
            # Logic
            helper(root.left, (add*10) + root.val)
            helper(root.right, (add*10) + root.val)
        helper(root, 0)
        
        return self.sum
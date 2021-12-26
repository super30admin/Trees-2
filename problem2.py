# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode : Yes
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    valid = True
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root==None:
            return self.valid
        self.checkSymmetry(root.left,root.right)
        return self.valid

    def checkSymmetry(self,root1,root2):
        #base
        if (not root1 and not root2):
            return
        if (not root1 or not root2 or root1.val!=root2.val):
            self.valid = False
            return

        #logic
        self.checkSymmetry(root1.left,root2.right)
        self.checkSymmetry(root1.right,root2.left)
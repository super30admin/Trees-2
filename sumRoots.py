# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def findSum(self, root, sums, cur):
        
        #base
        if root is None:
            return 0
         
        #logic
        cur = cur * 10 + root.val
        if ((root.left == None) & (root.right == None)):
            sums += cur
            return sums
        return self.findSum(root.left, sums, cur) + self.findSum(root.right, sums, cur)
      
        
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0
        
        return self.findSum(root, 0, 0)
        
        

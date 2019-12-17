# Time Complexity : O(n)
# Space Complexity : O(n) Recursion Stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Base condition

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __helper(self, root, value):
        
        if root is None:
            return
            
        self.__helper(root.left, value*10 + root.val)
        self.__helper(root.right, value*10 + root.val)
        if root.left is None and root.right is None:
            self.summ += value * 10 + root.val
        
        
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.summ = 0
        self.__helper(root, 0)
        return self.summ
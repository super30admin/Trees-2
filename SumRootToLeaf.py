# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
'''Time Complexity: O(n)
Space Complexity: O(h)'''
class Solution(object):
    def helper(self, prev, root,add):
        #if the root node is none, return current sum
        if not root:
            return add
        #update the prev number
        prev=prev*10+root.val
        
        #check if root node, if it is a root node then update the sum and return the sum
        if root.left is None and root.right is None:
            add+=prev
            return add
        #left and right iteration
        add=self.helper(prev, root.left,add)
        add=self.helper(prev, root.right,add)
        return add
        
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        prev=0
        add=0
        
        return self.helper(prev,root,add)
        

"""
Problem : 2

Time Complexity : O(n)
Space Complexity : O(h) //h=height of the tree

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Initializing the sum variable to zero, calculating the value at every current node
if the node is leaf node, then adding the current value to sum, otherwise adding 0 to sum
recusrsively calling the left and right node of every node, returning sum at the end
"""

# Sum root to leaf numbers

# Approach - 1

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.summ=0
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.helper(root,0)
        return self.summ
    
    def helper(self,root,currName):
        if root==None:
            return self.summ
        
        currName=currName*10+root.val

        if root.left==None and root.right==None:
            self.summ+=currName
            return self.summ
        left=self.helper(root.left,currName)
        right=self.helper(root.right,currName)
        return left+right
        
# Approach - 2

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):

    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        
        return self.helper(root,0)
    
    def helper(self,root,currName):

        if root==None:
            return 0
        
        currName=currName*10+root.val

        if root.left==None and root.right==None:
            return currName
        left=self.helper(root.left,currName)
        right=self.helper(root.right,currName)
        return left+right
        
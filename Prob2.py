#Time complexity: O(n)   
#Space complexity: O(h) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

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
        #total sum
        self.totSum = 0
        if root is None:
            return 0
        def helper(root,curSum):
            if root is None:
                return
            #creating number until we reach leaf
            curSum = curSum*10 + root.val
            helper(root.left,curSum)
            #if leaf is reached add number to total
            if root.left is None and root.right is None:
                self.totSum += curSum
            helper(root.right,curSum)
        helper(root,0)
        return self.totSum
        
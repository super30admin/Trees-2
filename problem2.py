# // Time Complexity : O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode : Yes
# Definition for a binary tree node.
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    res = 0
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root == None:
            return
        else:
            self.accSum(root,0)
            return self.res

    def accSum(self,root,curSum):

        curSum = curSum * 10 + root.val
        #check for leaf node
        if (not root.left and not root.right):
            self.res += curSum
            return
        if (root.left):
            self.accSum(root.left,curSum)
        if (root.right):
            self.accSum(root.right,curSum)





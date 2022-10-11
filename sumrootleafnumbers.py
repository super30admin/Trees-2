##Time Complexity : O(n)
##Space Complexity : O(h), h-height of the tree
##Did this code successfully run on Leetcode : Yes
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
        def dfs(current, num):
            if not current:
                return 0
            num = num * 10 + current.val
            if not current.left and not current.right:
                return num
            return dfs(current.left, num) + dfs(current.right, num)
        return dfs(root, 0)
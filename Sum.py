# // Time Complexity : O(n)
# // Space Complexity : O(h)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : no

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

        def sumTree(result, node):
            if not node:
                return 0
            result = (result * 10) + node.val
            if not node.right and not node.left:
                return result
            return sumTree(result, node.left) + sumTree(result, node.right)

        return sumTree(0, root)

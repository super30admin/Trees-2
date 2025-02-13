# Time Complexity : O(n) - n is number of nodes in tree
# Space Complexity : O(H) - H is height of the tree, for recursion stack
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
Once leaf node is encountered (left and right node are null), add the current sum to result
"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    result = 0
    def sumNumbers(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        self.helper(root, 0)
        return self.result

    def helper(self, root, current):

        if root is None: return

        current = current*10 + root.val
        if root.left is None and root.right is None:
            self.result += current

        self.helper(root.left, current)
        self.helper(root.right, current)
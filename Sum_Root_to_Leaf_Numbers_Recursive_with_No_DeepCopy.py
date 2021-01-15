# Created by Aashish Adhikari at 10:00 AM 1/15/2021

'''
Time Complexity:
O(n) since we traverse to each node once.

Space Complexity:
O(height of the tree) as we are maintaining a recursive stack under the hood.
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):

    def helper(self, node, current_sum):



        # base case
        if node.left is None and node.right is None:
            self.total += ((current_sum* 10) + node.val)

        if node.left is not None:
            self.helper(node.left, (current_sum* 10) + node.val)

        if node.right is not None:
            self.helper(node.right, (current_sum* 10) + node.val)

    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """

        if root is None:
            return 0

        self.total = 0

        self.helper(root, self.total)

        return self.total
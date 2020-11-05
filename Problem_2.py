"""
Time Complexity : O(n) 
Space Complexity : O(h) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
We  iterate through each and every sum and calculate the local sum, ie, sum upto that node and do that
consecutively for all node untill we reach the leaf nodes.As soon as we hit the leaf node, we add the sum to
our global result
"""
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
        global result
        result = 0
        if not root:
            return 0
        self.helper(root, 0)
        return result

    def helper(self, root, summ):
        global result
        if not root.left and not root.right:
            result += summ*10+root.val
        summ = summ*10+root.val
        if root.left:
            self.helper(root.left, summ)
        if root.right:
            self.helper(root.right, summ)

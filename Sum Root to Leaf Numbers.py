# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
TC: O(N)
SC: O(1)
"""

class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        res = 0
        
        def getSum(node, current_sum):
            
            if node.left is None and node.right is None:
                res[0] += current_sum + node.val
                return
            curr = current_sum + node.val
            if node.left :
                getSum(node.left, curr * 10)
            if node.right:
                getSum(node.right, curr * 10)
        
        getSum(root, 0)
        return res[0]
            

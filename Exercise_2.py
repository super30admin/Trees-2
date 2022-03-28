# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    result_value = 0
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def helper(root, sum_value):
            if root == None:
                return
            sum_value = sum_value*10 + root.val
            helper(root.left, sum_value)
            if (root.left == None and root.right ==None):
                self.result_value +=sum_value
            helper(root.right, sum_value)
                
            return self.result_value
        
        return helper(root, 0)
# Time Complexity: O(n)
# Space complexity: O(n)
# Program ran on leetcode with success

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
        return self.helper(root, 0)
    
    def helper(self, root, curr):
        if root is None:
            return 0
            
        curr = curr * 10 + root.val
            
        if root.left is None and root.right is None:
            return curr
            
        return self.helper(root.left, curr) + self.helper(root.right, curr)
        
        
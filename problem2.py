# Time complexity is O(N) and space complexity is O(h)
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
        
        def dfs(curr, num):
            if not curr:
                return 0
            
            num = num*10+curr.val
            
            if not curr.left and not curr.right:
                return num
            
            return dfs(curr.left, num)+dfs(curr.right, num)
        
        return dfs(root, 0)
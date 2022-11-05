# Time Complexity: O(n)
# Space Complexity: O(h) -> h is height of tree
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No


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
        if not root:
            return None
        
        self.res = 0
        
        def helper(node, s):
            if node:
                s = s*10 + node.val
            
                if node.left == None and node.right == None:
                    self.res+=s
                    return
                
                helper(node.left, s)
                helper(node.right, s)
        
        helper(root, 0)
        return self.res          
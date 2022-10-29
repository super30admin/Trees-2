'''
Time Complexity: O(n)
Space Complexity: O(n)
'''
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
        s = 0
        n = 0
        rs = []
        ns = []
        while(root or len(rs)>0):
            while(root):
                rs.append(root)
                n = n*10+root.val
                ns.append(n)
                root = root.left
            root = rs.pop()
            n = ns.pop()
            if(not root.left and not root.right):
                s += n
            root = root.right
        return s
        
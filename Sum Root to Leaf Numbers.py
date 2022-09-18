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
        self.res = 0
        def pathsum(root,temp):
            if(root.left==None and root.right==None):
                self.res = self.res+temp+root.val
                return
            if(root.left):
                pathsum(root.left,(temp+root.val)*10)
            if(root.right):
                pathsum(root.right,(temp+root.val)*10)
        pathsum(root,0)
        return self.res
        
        
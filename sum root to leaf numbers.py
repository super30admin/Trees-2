# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    total = 0
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if(root == None):
            return 0
        
        self.calculateSum(root, 0)
        return self.total
    
    
    
    def calculateSum(self, root, prev):
        if root:
            current = prev * 10 + root.val

            if(root is not None and root.left == None and root.right == None):
                self.total += current
                return

            self.calculateSum(root.left, current)
            self.calculateSum(root.right, current)

        return

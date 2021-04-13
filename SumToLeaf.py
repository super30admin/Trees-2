# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity is O(n), n being the number of nodes
# Space Complexity is O(h), for the stack, h being the height of the tree
class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if(root is None):
            return 0
        stack = [(root,0)]
        totSum = 0
        while(stack):
            root,prev = stack.pop()
            currSum = prev*10 + root.val
            if(root.left is None and root.right is None):
                totSum += currSum
            if(root.left is not None):
                stack.append((root.left,currSum))
            if(root.right is not None):
                stack.append((root.right,currSum))
        return totSum
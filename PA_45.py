#LC 129 - Sum Root to Leaf Numbers
#Time Complexity - O(n) where n is number of nodes
#Space Complexity - O(h) where h is the height of the tree
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
            return 0
        stack = []
        ans = 0
        tmp = 0
        while root or len(stack) != 0:
            while root:
                tmp = tmp*10 + root.val
                stack.append([root,tmp])
                root = root.left
            node,val = stack.pop()
            if not node.left and not node.right:
                ans = ans + val
            tmp = val
            root = node.right
        return ans
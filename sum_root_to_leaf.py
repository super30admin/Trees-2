# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    total_sum = 0

    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def recur(cur_sum,root):
            if root is None:
                return
            if (root.left==None and root.right==None):
                self.total_sum = self.total_sum + cur_sum*10 + root.val
            else:
                cur_sum = (cur_sum*10)+root.val
                recur(cur_sum,root.left)
                recur(cur_sum,root.right)
        recur(self.total_sum,root)
        return self.total_sum
                
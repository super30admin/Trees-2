# T.C = O(n) S.C = O(n)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    result = 0
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """

        self.helper(root,0)
        return self.result

    def helper(self,root,currNum):
        if(root is None):
            return

        currNum = currNum * 10 + root.val

        if(root.left is None and root.right is None):
            self.result += currNum

        self.helper(root.left,currNum)
        self.helper(root.right,currNum)
        
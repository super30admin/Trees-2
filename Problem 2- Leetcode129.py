#Time Complexity: O(n)
#Space Complexity: O(h) where h is the height of the tree

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        return self.helper(root, 0)

    def helper(self, root, currNum):
        if root is None:
            return 0

        currNum = currNum * 10 + root.val

        if root.left is None and root.right is None:
            return currNum

        left = self.helper(root.left, currNum)
        right = self.helper(root.right, currNum)

        return left + right
        
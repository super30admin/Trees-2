"""
Time:O(n)
Space:O(1) [O(n) on recrusive stack]
Leet: Accepted
Problems: No problems!
"""


class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """

        def helper(root,result):
            if not root:
                return 0
            if root.left is None and root.right is None:
                return root.val + (result*10)

            return helper(root.left, (result*10)+root.val) + helper(root.right, (result*10)+root.val)

        return helper(root,0)

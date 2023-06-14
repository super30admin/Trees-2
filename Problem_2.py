# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

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
        num = 0
        arr = []
        def DFS(root, num):
            if root is None: return
            if (not root.left) and (not root.right):
                arr.append(num + root.val)
                return
            DFS(root.left, ((num + root.val) * 10))
            DFS(root.right, ((num + root.val) *10))
        DFS(root, num)
        return sum(arr)
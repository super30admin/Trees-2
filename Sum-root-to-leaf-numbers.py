# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity: O(n) n is the number of nodes
# Space Complexity: O(1)
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.result = 0
        def recurse(root, currsum):
            if not root:
                return
            currsum = currsum * 10 + root.val
            recurse(root.left, currsum)
            if not root.left and not root.right:
                self.result += currsum
            recurse(root.right, currsum)
        recurse(root, 0)
        return self.result
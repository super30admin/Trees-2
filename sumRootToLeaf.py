#Time Complexity: O(n)
#Space Complexity: O(n)
#did it run on leetcode: Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        queue = [(root, root.val)]
        result = 0
        while queue:
            node, val = queue.pop(0)
            if not node.left and not node.right:
                result += val
            if node.left:
                queue.append((node.left, val*10 + node.left.val))
            if node.right:
                queue.append((node.right, val*10 + node.right.val))
        return result
        


# Time: O(n)
# Space: O(h) (worst O(n), avg O(log n))

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
        sum = 0
        stack = [(root, root.val)]
        
        while stack:
            node, acc = stack.pop()
            if not node.left and not node.right:
                sum += acc
            if node.right:
                stack.append((node.right, acc*10 + node.right.val))
            if node.left:
                stack.append((node.left, acc*10 + node.left.val)) 
        return sum

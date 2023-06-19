from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if not root:
            return
        self.sum = 0

        def helper(node, path):
            # base
            if node.left is None and node.right is None:
                path.append(node.val)
                self.sum += int("".join(map(str, path)))
                return
                
            # main
            path.append(node.val)
            if node.left:
                helper(node.left, path.copy())
            if node.right:
                helper(node.right, path.copy())
            path.pop()

        
        helper(root, [])
        return self.sum

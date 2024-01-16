""" Explanation: To solve this problem, I used DFS. we start at the root and keep iterating until we hit the last leaf of that traversal,
    then we come back up to the root and traverse the other direction.
    Time Complexcity: O(n)
    Space Complexcity: O(n)
    Code compiled on LC: Yes
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def sumNumbers(self, root: [TreeNode]) -> int:
        
        # DFS approach
        res = 0
        
        def dfs(root, path):
            nonlocal res
            path += str(root.val)
            if root.left is None and root.right is None:
                res += int(path)
                return
            if root.left is not None:
                dfs(root.left, path)
            if root.right is not None:
                dfs(root.right, path)
            return
        path = ''
        dfs(root, path)
        return res
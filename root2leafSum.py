
"""
TC : O(N) to traverse N nodes
SP: O(H) Height of th tree, worstcase it would be O(N)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.result = 0
        def dfs(root, curr):
            if not root:
                return
            if not root.left and not root.right:
                self.result+=int(curr+str(root.val))
                return
            curr+=str(root.val)
            dfs(root.left, curr)
            dfs(root.right, curr)
        dfs(root, "")
        return self.result


        
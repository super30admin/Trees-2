# time : O(n)
# space: O(H) H is tree height

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    res = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def dfs(root, cursum):
            if not root:
                return
            
            cursum = root.val + cursum*10

            if not root.left and not root.right:
                self.res += cursum
            
            dfs(root.left, cursum)
            dfs(root.right, cursum)
        
        dfs(root, 0)
        return self.res

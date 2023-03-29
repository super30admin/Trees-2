# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        p1 = root
        p2 = root
        global flag
        flag = True
        def dfs(p1, p2):
            global flag
            if not flag: return
            if not p1 and not p2: return
            if not p1 or not p2:
                flag = False
                return
            if p1.val != p2.val:
                flag = False
            dfs(p1.left, p2.right)
            dfs(p1.right, p2.left)
        dfs(p1, p2)
        return flag




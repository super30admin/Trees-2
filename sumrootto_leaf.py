# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this : No
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
#         O(n)--->TC
# O(n)--->sc
        def dfs(root,k=0):
            if not root: 
                return 0
            if not root.left and not root.right:
                return k+root.val
            return dfs(root.left,(k+root.val)*10)+dfs(root.right,(k+root.val)*10)
        return dfs(root,0)
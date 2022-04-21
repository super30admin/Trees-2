#Time Complexity :o(n)
# Space Complexity :o(n)
# Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : here i used DFS. Add root val nd previos value.


# Your code here along with comments explaining your approach
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        res = 0
        arr = []
        def dfs(root, res):
            if root is None: return
            if not root.left and not root.right:
                arr.append(res+root.val)
                return
            dfs(root.left, (res+root.val)*10)
            dfs(root.right, (res+root.val)*10)
        dfs(root, res)
        return sum(arr)
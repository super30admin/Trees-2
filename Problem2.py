class Solution(object):
    def sumNumbers(self, root):
        """
        The idea is to multiply 10 with prev node and add it to the cur node.
        Perform DFS
        Time complexity: O(n) where n is no of nodes
        Space complexity is O(h) where h is the height of tree
        :type root: Optional[TreeNode]
        :rtype: int
        """
        def dfs(cur, num):
            if not cur:
                return 0

            num = num * 10 + cur.val
            if not cur.left and not cur.right:
                return num
        
            return dfs(cur.left, num) + dfs(cur.right, num)
        return dfs(root, 0)
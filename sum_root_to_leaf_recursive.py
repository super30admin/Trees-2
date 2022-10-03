# TC: O(n)
# SC: O(h)
class Solution:
    def __init__(self):
        self.sum = 0

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return
        self.dfs(root, 0)
        return self.sum

    def dfs(self, node, num):
        # base condition
        if node == None:
            return
        print(node.val)
        if node.left == None and node.right == None:
            self.sum = self.sum + num*10 + node.val
            return
        self.dfs(node.left, 10*num + node.val)
        self.dfs(node.right, 10*num + node.val)

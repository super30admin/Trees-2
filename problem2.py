class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def helper(node, num):
            if node is None:
                return 0
            num = num * 10 + node.val
            if node.left is None and node.right is None:
                return num
            return helper(node.left, num) + helper(node.right, num)
        
        return helper(root, 0)
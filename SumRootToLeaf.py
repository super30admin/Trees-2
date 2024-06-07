# Time Complexity : O(n), where n is the number of nodes of the tree
# Space Complexity : O(h), where h is the height of the tree. Space is stored in recursion stack.
class Solution:
    def dfs(self, root, curSum):
        if root is None:
            return 0
        case1 = self.dfs(root.left, curSum * 10 + root.val)  # Left Recursive
        case2 = self.dfs(root.right, curSum * 10 + root.val)  # Right Recursive
        if root.left is None and root.right is None:  # Reached Leaf
            return curSum * 10 + root.val
        return case1 + case2

    def sumNumbers(self, root):
        if root is None:
            return 0
        return self.dfs(root, 0)

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

solution = Solution()

# Example 1:
root = TreeNode(4)
root.left = TreeNode(9)
root.right = TreeNode(0)
root.left.left = TreeNode(5)
root.left.right = TreeNode(1)
print(solution.sumNumbers(root))  # Expected output: 1026

# Example 2:
root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
print(solution.sumNumbers(root))  # Expected output: 25

# Example 3:
root = TreeNode(1)
root.left = TreeNode(0)
print(solution.sumNumbers(root))  # Expected output: 10
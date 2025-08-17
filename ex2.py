# Time Complexity: O(n)
# Space Complexity: O(h)

class Solution:
    def __init__(self):
        self.sum = 0

    def helper(self, root: Optional[TreeNode], num: int) -> None:
        if root is None:
            return

        # Append current node value to path number
        num = num * 10 + root.val

        # if leaf node, add the path number to total sum
        if root.left is None and root.right is None:
            self.sum += num
            return

        self.helper(root.left, num)
        self.helper(root.right, num)

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root, 0)
        return self.sum

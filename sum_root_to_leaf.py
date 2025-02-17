class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0
        self.sum = 0
        self.helper(root, 0)
        return self.sum
    
    def helper(self, root: Optional[TreeNode], currNum :int) -> None:
        if root == None:
            return
        if root.left == None and root.right == None:
            self.sum = self.sum + currNum * 10 + root.val
            return

        self.helper(root.left, currNum * 10 + root.val)
        self.helper(root.right, currNum * 10 + root.val)

# Time complexity - O(n)
# Space complexity - O(h)
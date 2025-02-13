# Time : O(n * h)
# Space: O(h)
class Solution:
    sum = 0

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root, 0)
        return self.sum

    def helper(self, root: Optional[TreeNode], currSum: int) -> None:

        if root is None:
            return
        
        if root.left is None and root.right is None:
            self.sum += currSum + root.val

        self.helper(root.left, (currSum + root.val) * 10)
        self.helper(root.right, (currSum + root.val) * 10)
        

# Time: O(n*h)
# Space: O(n or h)
class Solution:
    sum = 0

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        return self.helper(root, 0)

    def helper(self, root: Optional[TreeNode], currSum: int) -> int:

        if root is None:
            return 0
        
        if root.left is None and root.right is None:
            return currSum * 10 + root.val

        return self.helper(root.left, currSum * 10 + root.val) + self.helper(root.right, currSum * 10 + root.val) 
        
        
               
        
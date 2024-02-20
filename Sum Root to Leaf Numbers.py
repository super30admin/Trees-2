
#Time Complexity: O(n)
#Space complexity: O(h)

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.total_sum = 0
        if root is None:
            return self.total_sum # variable of the class
            
        self.helper(root, 0)
        return self.total_sum
        
    def helper(self, root, num):
        if root is None:
            return

        num = num * 10 + root.val

        # check if you are on a leaf node
        if root.left is None and root.right is None:
            self.total_sum += num
            return

        self.helper(root.left, num)
        self.helper(root.right, num)

# path to leaf sum
# time complexity: O(N)
# space complexity: O(N)
# Did this code successfully run on Leetcode : NA
# Any problem you faced while coding this : NA

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        total = 0
        def helper(root, curr_number):
            nonlocal total
            if root == None:
                return
            curr_number = curr_number*10 + root.val
            if root.left is None and root.right is None:
                total = total + curr_number
            helper(root.left, curr_number)
            helper(root.right, curr_number)
        
        helper(root, 0)
        return total
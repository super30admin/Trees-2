# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:

        """
		    Time Complexity: O(n)
        Space Complexity: O(n)
        Did this code successfully run on Leetcode: Yes

        Any problem you faced while coding this: No
        """

        def helper(root, running_sum):
            # Base Case
            if root is None:
                return 0
        
            # Update val
            running_sum = (running_sum*10 + root.val)
        
            # If current node is leaf, return the current value of val
            if root.left is None and root.right is None:
                return running_sum
        
            # Recurring sum of values for left and right subtree
            return (helper(root.left, running_sum) +
                    helper(root.right, running_sum))
        
        return helper(root, 0)

        

#// Time Complexity : O(n) 
# // Space Complexity : O(1)   
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No because i attended the class and then did the solution


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        result = 0
        def helper(root,currsum):
            nonlocal result
            if root == None:
                return
            currsum = currsum * 10 + root.val
            if root.left == None and root.right == None:
                result += currsum

            helper(root.left,currsum)
            helper(root.right,currsum)
        helper(root,0)
        return result

# Approach:
# 1. We will use a helper function to traverse the tree and calculate the sum of the path.
# 2. We will use a variable currsum to store the sum of the path.
# 3. We will use a variable result to store the sum of all the paths.
# 4. We will use a base case to check if the current node is None, if it is
# then we will return.


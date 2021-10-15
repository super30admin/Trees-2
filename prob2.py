# Time Complexity : O(N) as we go through all N nodes
# Space Complexity : O(H) as max space used is height H of the tree
# Did this code successfully run on Leetcode : Yes, both
# Any problem you faced while coding this : understanding how to use a global variable in Python
# Your code here along with comments explaining your approach

# In the first approach, the helper return type is void, 
# and we recursively go over left and right child, 
# updating the current sum to num * 10 + root.val, 
# as we are starting with 0
# when we reach a leaf, add the current sum to our global sum

# class TreeNode:

#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left 
#         self.right = right

# ----------------------------------------------------------------
# helper with return type void
# class Solution:

#     mysum = 0

#     def sumNumbers(self, root: Optional[TreeNode]) -> int:

#         global mysum
#         mysum = 0

#         if root is None:
#             return mysum
#         self.helper(root, 0)
#         return mysum
    
#     def helper(self, root, num) -> None:

#         global mysum
#         if root is None:
#             return
        
#         self.helper(root.left, num * 10 + root.val)
#         if root.left is None and root.right is None:
#             mysum += num * 10 + root.val

#         self.helper(root.right, num * 10 + root.val)



#-------------------------------------------------------------------
# helper with return type int
class Solution:

    def sumNumbers(self, root: Optional[TreeNode]) -> int:

        if root is None:
            return 0
        return self.helper(root, 0)

    def helper(self, root: TreeNode, num) -> int:

        if root is None:
            return 0
        
        if root.left is None and root.right is None:
            return num * 10 + root.val
        
        return self.helper(root.left, num * 10 + root.val) + self.helper(root.right, num * 10 + root.val)
    
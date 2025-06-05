# // Time Complexity : o(n) visiting all nodes 
# // Space Complexity : o(h) h is the hieght can be o(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : intuition behind the pass by value and reference


# // Your code here along with comments explaining your approach
# two approaches either update the global variable and find sum or either update locally when by passing the refernce and calculating bottim to top left+right

# Definition for a binary tree node.
from typing import List, Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        def helper(root, curr):
            # base
            if not root : return 0
            # logic
            curr = curr*10 + root.val
            if not root.left and not root.right:
                return curr
            left = helper(root.left, curr)
            right = helper(root.right, curr)
            return left + right
        return helper(root, 0)

# class Solution:
#     def __init__(self):
#         self.res = 0

#     def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
#         def helper(root, curr):
#             # base
#             if not root : return
#             # logic
#             curr = curr*10 + root.val
#             helper(root.left, curr)
#             if not root.left and not root.right:
#                 self.res += curr
#             helper(root.right, curr)
#         helper(root, 0)
#         return self.res


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# class Solution:
#     def __init__(self):
#         self.res = 0

#     def sumNumbers(self, root: Optional[TreeNode]) -> int:
        

#         def helper(root, curr):
#             # base
#             if not root : return
#             # logic
#             curr =curr*10 + root.val
#             if not root.left and not root.right:
#                 self.res += curr
#             helper(root.left, curr)
#             helper(root.right, curr)
#         helper(root, 0)
#         return self.res


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# class Solution:
#     def sumNumbers(self, root: Optional[TreeNode]) -> int:
#         res = 0
#         def helper(root, curr):
#             nonlocal res
#             # base
#             if not root : return 0
#             # logic
#             if not root.left and not root.right:
#                 res+= curr*10 + root.val
            
#             helper(root.left, curr*10+root.val)
#             helper(root.right, curr*10+root.val)
#         helper(root, 0)
#         return res


        


        

        
        
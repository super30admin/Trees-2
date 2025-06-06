# // Time Complexity :O(n)
# // Space Complexity :O(H)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

# https://leetcode.com/problems/sum-root-to-leaf-numbers/
# # // Your code here along with comments explaining your approach
# update current sum as you go

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.result=0
        def helper(root,curr):
            # print(curr,self.result)
            if not root: return 0
            curr= curr*10 +root.val
            if not root.left and not root.right:
                return curr
            return helper(root.left,curr)+helper(root.right,curr)
            
        
        return helper(root,0)
            

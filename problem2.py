# Time Complexity : O(n)
# Space Complexity : O(N)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 
# Your code here along with comments explaining your approachclass Solution:


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    sumv =0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        self.helper(root,0)
        print(self.sumv)
        return self.sumv
    def helper(self,root,cursum):
        if root is None:
            return
        if root.left is None and root.right is None:
            self.sumv += cursum*10+root.val
        print(self.sumv)
        self.helper(root.left,cursum*10+root.val)
        self.helper(root.right,cursum*10+root.val)
        
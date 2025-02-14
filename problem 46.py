#  https://leetcode.com/problems/sum-root-to-leaf-numbers/

# Time Complexity : O(n)
# Space Complexity : O(h) h = height of the tree
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result =  0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root,0)
        return self.result
    def helper(self, root: Optional[TreeNode], curr: int):
        if root == None:
            return
        
        curr = curr*10 + root.val
        if(root.left == None and root.right == None):
            self.result += curr
        self.helper(root.left,curr)

        self.helper(root.right,curr)

        
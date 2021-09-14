# Time Compexity : O(N)
# Space COmplexity : O(H)
# Approach to solve this problem: 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root == None:                                    # If we dont have a root
            return 0
        self.result = 0                                     # Declaration of result
        self.findSum(root, 0)
        return self.result  
    
    def findSum(self, root, val):
        curr = val*10 + root.val                             # Calculation
        if root.left == None and root.right == None:         # leaf Node
            self.result += curr
            return
        
        if root.left != None:                                # Going to the left side till its None
            self.findSum(root.left, curr)
        if root.right != None:                               # Going to the right side till its None
            self.findSum(root.right, curr)
        
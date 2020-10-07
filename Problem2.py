# Time Complexity: O(N)
# Space Complexity: O(log(N))
# Passed Leetcode

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def recurse(self, root, curr_val):
        
        if not curr_val:
            curr_val = str(root.val)
        else:
            curr_val += str(root.val)
        
        if not root.left and not root.right:
            # Leaf Node
            self.output += int(curr_val)
            return
            
        if root.left:
            self.recurse(root.left, curr_val)
        
        if root.right:
            self.recurse(root.right, curr_val)
        
    def sumNumbers(self, root: TreeNode) -> int:
        
        
        if not root:
            return 0
        
        self.output = 0
        
        self.recurse(root, None)
        
        return self.output
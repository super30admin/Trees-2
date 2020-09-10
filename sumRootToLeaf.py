# // Time Complexity : 
# // Space Complexity : 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach:

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    #keep a global variable for output and assign it zero
    def __init__(self):
        self.output = 0
    
    
    def sumNumbers(self, root: TreeNode) -> int:
        
        #call the recursive function and return output
        self.recur(root, 0)
        return self.output
        
    
    def recur(self, root: TreeNode, prev):
        
        #base case
        if root == None:
            return
        
        #calculate the current value
        curr = prev*10 + root.val
        
        #when at leaf node, add to output
        if root.left == None and root.right == None:
            self.output += curr
            return
        
        #make recursive calls
        self.recur(root.left, curr)
        self.recur(root.right, curr)
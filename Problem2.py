# sum from root to leaf

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def helper(self, root: TreeNode, add: int  ) -> int:
        if root == None:
            return 0
        
        add = add*10 + root.val
        
        val1 = self.helper(root.left, add)
        val2 = self.helper(root.right, add)
        
        if val1 == 0 and val2 == 0:
            return add
        else:
            return val1 + val2
        
        
        
    def sumNumbers(self, root: TreeNode) -> int:
        
        if root == None :
            print("here")
            
            return 0
        
        if root.left == None and root.right == None:
            return root.val
        
        add = 0
        
        value = root.val
        left = root.left
        right = root.right
        
        val1 = self.helper(left, value)
        val2 = self.helper(right, value)
        
        return val1 + val2
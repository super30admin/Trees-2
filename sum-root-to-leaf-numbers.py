# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root.left == None and root.right == None:
            return root.val
        
        return self.helper(root,0)
        
        
    
    def helper(self, root:TreeNode, sumv:int):
        #base
        if root == None:
            return 0
        
        #print("Up")
        #print(sumv,root.val)
        
        #logic
        if (root.left == None) and (root.right == None):
         #   print("in", 10 * sumv + root.val)
            return 10 * sumv + root.val
         
        #print("ooo",root.val, root.left.val,root.right.val)
        x = self.helper(root.left, 10 * sumv + root.val) + self.helper(root.right, 10 * sumv + root.val)
        
        #print(x)
        
        return x
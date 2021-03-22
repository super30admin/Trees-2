# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def treePathsSumUtil(self,root, val): 
  
        # Base Case 
        if root is None: 
            return 0

        # Update val 
        val = (val*10 + root.val) 

        # If current node is leaf, return the current value of val 
        if root.left is None and root.right is None: 
            return val 

        # Recur sum of values for left and right subtree 
        return (self.treePathsSumUtil(root.left, val) + 
                self.treePathsSumUtil(root.right, val)) 
    
    def sumNumbers(self, root: TreeNode) -> int:
        if root is None:
            return 0
        if root.left is None and root.right is None:
            return root.val
        return self.treePathsSumUtil(root.left, root.val) + self.treePathsSumUtil(root.right, root.val)
    

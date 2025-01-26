# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __init__(self):
        self.globalSum = 0
    
    
    def rootToLeafSum(self,node,localSum):
        
        # base
        
        if node == None:
            return 
        
        elif node.left == None and node.right == None:
            # Leaf here
            self.globalSum += (localSum*10 + node.val)
            return
        
        # logic
        
        # 1. Traverse on LHS of the tree
        self.rootToLeafSum(node.left,(localSum*10 + node.val))
        
        # 2. Traverse on the RHS of the tree
        self.rootToLeafSum(node.right,(localSum*10 + node.val))
    
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        self.rootToLeafSum(root,0)
        
        return self.globalSum
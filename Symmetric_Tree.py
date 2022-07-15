# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        def solve(tree1,tree2):
            
            if tree1 is None and tree2 is None:
                return True
            
            elif tree1 is None:
                return False
            
            elif tree2 is None:
                return False
            
            return tree1.val==tree2.val and solve(tree1.left,tree2.right) and solve(tree1.right,tree2.left)
            
        
        return solve(root,root)
                
        
                
                
                
        
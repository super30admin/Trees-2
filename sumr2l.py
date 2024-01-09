# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:        
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        def preorder(node, currNo):
            nonlocal result
            
            if node:
                currNo = node.val + 10*currNo
                
                if not (node.left or node.right):
                    result = result + currNo
                    
                preorder(node.left, currNo)
                preorder(node.right, currNo)
                
        result = 0
        preorder(root, 0)
        return result
        

        

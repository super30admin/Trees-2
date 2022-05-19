# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        globalSum = 0
        localSum = 0
        stack = []
        
        node = root
        
        while node != None or len(stack) != 0:
            
            while node != None:
                
                # Push to the stack
                stack.append((node,localSum))
                
                # Update localSum 
                localSum = (localSum * 10) + node.val
                
                # Update the node
                node = node.left 
                continue
            
            # Pop from the stack
            node,localSum = stack.pop()
            
            # Check for leaf-node
            if node.left == None and node.right == None:
                
                # leaf-node
                localSum = (localSum*10) + node.val 
                
                # Update global-sum
                globalSum  += localSum
                
                # Pop from stack -- conditionally
                if len(stack) > 0:
                    node,localSum = stack.pop()
                
                else:
                    node = None
                    localSum = None
            
            # Traverse on RHS
            if node != None and localSum != None:
                localSum = (localSum*10) + node.val
                node = node.right
            
            continue
        
        return globalSum
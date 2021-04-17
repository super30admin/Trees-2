# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = 0
    #Recursive Approach
    def sumNumbers_r(self, root: TreeNode) -> int:
        if not root:
            return
        
        self.helper(root,0)
        
        return Solution.result
    
    def helper(self,root,sumval):
        
        if not root:
            return
        
        currentsum = 10* sumval + root.val
        print(f"Currentsum: {currentsum}")
        self.helper(root.left,currentsum)
        
        if not root.left and not root.right:
            Solution.result += currentsum
            print(f"result {Solution.result}")
        
        self.helper(root.right,currentsum)
    
    #iterative Approach
    def sumNumbers(self, root: TreeNode) -> int:
        if not root:
            return
        stack = []
        
        result = 0
        currentsum = 0
        
        while root or stack:
            while root:
                currentsum = currentsum*10 + root.val
                stack.append((currentsum,root))
                root = root.left
            
            pair = stack.pop()
            currentsum = pair[0]
            root = pair[1]
            if root.left == None and root.right == None:
                result += currentsum
                
            root = root.right
        
        return  result
            
            

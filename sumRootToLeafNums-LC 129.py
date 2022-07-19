# Time Complexity = O(n)
# Space Complexity = O(h), recursive stack, where h is the height of the tree


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        self.totalSum = 0           # Declaring a global variable for sum as this variable is altered only once we are reaching the leaf node of every path
        
        if root == None:
            return self.totalSum
        
        
        self.helper(root, 0)        # Here 'num' is our local variable because it is changing as we advance to different nodes and we need the immediate previous value to calculate for the next 
        
       
        return self.totalSum
    
    
    
    def helper(self, root, num):
        
        # Base
        if (root == None):
            return
        
        # Any order of traversal works
        # Condition to check if on a leaf node
        if (root.left == None and root.right == None): 
            self.totalSum = self.totalSum + ((num * 10) + root.val)       # Each digit in the node path differs its previous by a factor of 10 ==> 4, 49, 495
            return              
        
        
        self.helper(root.left, (num * 10) + root.val)
        self.helper(root.right, (num * 10) + root.val) 
        
    
        
        
# Iterative approach
# 2 stacks used: 1 for storing the root and the otehr for num value uptil that root
'''
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        num = 0
        sumT = 0
        
        if root == None:
            return sumT
        
        nodeS = []
        numS = []
        
        while (root != None or nodeS):
            while root:
                nodeS.append(root)
                num = (num * 10) + root.val
                numS.append(num)
                root = root.left
            
            root = nodeS.pop()
            num = numS.pop()
            
            # Leaf Node condition
            if (root.left == None and root.right == None):
                sumT = sumT + num
                
            root = root.right
            
        return sumT
            
'''        

        
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Pair:
    
    node = TreeNode()
    value = 0
    
    def __init__(self, node: TreeNode, value: int):
        self.node = node
        self.value = value
        
    def getNode(self):
        return self.node
    
    def getValue(self):
        return self.value
        

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        finalSum =0
        stack = []
        runningSum = 0
        print(root)
        while root is not None or stack:
            while root is not None:
                runningSum = runningSum*10 + root.val
                stack.append(Pair(root, runningSum))
                root = root.left
            
            p = stack.pop()
            root = p.getNode()
            runningSum = p.getValue()
            
            if root.left is None and root.right is None:
                print(runningSum)
                finalSum += runningSum
            
            root = root.right
            
        
        return finalSum
    
#  Time complexity is O(n), this is iterative approach..
        
        
        
        
        

#Sum Root to Leaf Numbers

#Time complexity -> On  -> Iterating throguh each node once
#Space complexity -> Oh ->Stack for the tree depyh
# 
# Iterate over the left and right nodes and maintain a current number, on moving to child node multiply the current number
# by 10 and add the root value to the current number. Once at leaf add to the number tot he result  

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        result = 0
        currentNumber = 0
        return self.helper(root,currentNumber*10, result)

    
    def helper(self,root,currentNumber, result ):
        
        currentNumber = currentNumber + root.val

        if root.left !=None:
            result = self.helper(root.left, currentNumber*10, result)

        if root.right != None:
            result = self.helper(root.right, currentNumber*10, result)
              
        if root.left == None and root.right == None:
            result+=currentNumber
        return result

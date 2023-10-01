# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity: O(n) where n is the number of elements in tree
# Space Complexity: O(h) where h is height of the tree 
class Solution:
    
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        #global variable sum is set to 0
        self.sum = 0 
        # If root is empty return 0
        if root is None:
            return 0 
        # Call recursive function to calculate sum       
        self.calculateSum(root, 0)
        return self.sum
    
    # Recursive function to calculate sum
    def calculateSum(self, root, currSum):
        if root is None:
            return   
        
        # Traversing left side of the tree  
        self.calculateSum(root.left, currSum*10+root.val)
        # InOrder
        #If leaf node is reached them add to sum
        if root.left is None and root.right is None:
            self.sum = self.sum + currSum * 10 + root.val  
        #Traversing right side of the tree
        self.calculateSum(root.right, currSum*10+root.val) 
           
        
        
        


        

        
        


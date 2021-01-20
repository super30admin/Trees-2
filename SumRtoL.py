# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def sumNumbers(self, root: TreeNode) -> int:
        
        """
        Description: Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number
        
        Time Complexicity: O(n), where n are number of elements in the tree (each element visited)
        Space Complexicity: O(h), where h is height of the tree (recursive stack)
        
        Approach:
        1. maintain currSum as a local variable in recursive function along with current root
        2. use currSum*10 + root.val until both left and right child are null to get a < h-digit number
        3. add the above to global variable defined as result.
        
        """
        if root == None: return 0
        self.result = 0
        
        return self.helper(root, 0)
    
    def helper(self, root, currSum):
        
        # Base
        if root == None: return
        currSum = currSum*10 + root.val
        
        # Logic
        if root.left == None and root.right == None:
            self.result += currSum
            
        self.helper(root.left, currSum)
        self.helper(root.right, currSum)
        
        return self.result

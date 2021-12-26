#Time Complexity : O(n) - For visiting each node in the tree inorder to process the number till the leaf node.
#Space Complexitty : O(n) - For the recursive stack

class Solution:
    TotalSum = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        if root == None:
            return 0
        
        #0 passed in is the currentSum
        self.helper(root, 0)
        
        return self.TotalSum
       
    def helper(self, root, curSum):
        
        #Base
        if root == None:
            return 
        
        #Logic
        if root.left == None and root.right == None:
            self.TotalSum += curSum * 10 + root.val
            
        self.helper(root.left, curSum * 10 + root.val)
        self.helper(root.right, curSum * 10 + root.val)
        
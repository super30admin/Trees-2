# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.sum = 0
        self.calculateSum(root,0)
        return self.sum
    
    def calculateSum(self,root,num):
        
        if root == None:
            return 
        
        num = num*10 + root.val
        
        if root.left == None and root.right == None:
            self.sum += num
            return
        self.calculateSum(root.left,num)
        self.calculateSum(root.right,num)
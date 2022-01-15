# Time Complexity : O(N)
# Space Complexity : O(H) ~> Recursion Stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''Top Down Recursion with Global Result'''
class Solution:
    def __init__(self):
        self.result = 0
        
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def recur(root, number):
            if root.left == None and root.right == None:
                curr = number * 10 + root.val
                self.result += curr
                return 
                       
            curr = number * 10 + root.val
            if root.left:
                recur(root.left, curr)
            
            if root.right:
                recur(root.right, curr)
        
        
        recur(root, 0)
        return self.result

'''Bottom Up Recursion'''

class Solution:
    
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        def recur(root, number):
            if root.left == None and root.right == None:
                curr = number * 10 + root.val
                return curr
                       
            curr = number * 10 + root.val
            left = 0
            right = 0
            if root.left:
                left = recur(root.left, curr)
            
            if root.right:
                right = recur(root.right, curr)
            
            return left + right
        
        return recur(root, 0)
# Time Complexity :O(n)
# Space Complexity : O (n)

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

class Solution:
    def sumNumbers(self, root) -> int:
        return self.helper(root, 0)
    
    def helper(self, root, currNum):
        if root == None:
            return 0
        
        if root.left == None and root.right ==  None:
            return currNum*10+root.val
        return self.helper(root.right, currNum*10+root.val) + self.helper(root.left, currNum*10+root.val)
        
'''
Time Complexity : O(n)
Space Complexity: O(h)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        result = 0
        
        def sum1(root, localSum):
            if(root==None):
                return
            
            localSum = localSum*10 + root.val
            if(root.left==None and root.right==None):
                nonlocal result
                result += localSum
                return
            
            sum1(root.left, localSum)
            
            sum1(root.right, localSum)
        
        
        sum1(root, 0)
        return result

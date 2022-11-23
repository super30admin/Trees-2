# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
'''
Time Complexity -->
O(n)
Space Complexity-->
O(h) where h is the height of the tree
'''
class Solution:
    def __init__(self):
        self.result = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root,0)
        return(self.result)
    
    def helper(self, root, num):
        if root!=None:
            if root.left==None and root.right==None:
                self.result+=num*10+root.val
            
            self.helper(root.left,num*10+root.val)
            self.helper(root.right,num*10+root.val)
            
        
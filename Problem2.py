# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#Time Complexity-O(n+m) n-nodes m-edges
#Space Complexity-O(h) h-height

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        summ=0
        return self.add(root,summ)
        
    def add(self,root,summ):
        if root is None:
            return 0
        if root.left==None and root.right==None:
            return summ*10+root.val
        return self.add(root.left,summ*10+root.val)+self.add(root.right,summ*10+root.val)
        
            
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sumNumbers(self, root):
        self.s=0
        def traverse(root,path):
            if not root:
                return path
            
            left = traverse(root.left,path+str(root.val))
            right = traverse(root.right,path+str(root.val))
            if left and right:
                # if left==right:
                self.s+=int(left)
            
        traverse(root,"")
        return self.s
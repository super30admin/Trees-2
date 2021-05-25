# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = 0
    def sumNumbers(self, root: TreeNode, total=0) -> int:
        #Base
        if (root==None):
            return


        # Action
        total = (total*10) + root.val
        if root.left == None and root.right == None:
            self.result = self.result + total


        # Recurse
        self.sumNumbers(root.left,total)



        self.sumNumbers(root.right,total)

        return self.result

        

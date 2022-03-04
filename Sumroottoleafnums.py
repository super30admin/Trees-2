# TC: O(n); n is no.of nodes in tree
# SC: O(h); h is height of tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def sumNumbers(root, num):
            if(not root):
                return 0
            
            currSum = num*10+root.val
            
            if(not root.left and not root.right):
                return currSum
            
            return sumNumbers(root.left, currSum)+sumNumbers(root.right, currSum)
        return sumNumbers(root,0)

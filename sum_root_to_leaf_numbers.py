# Time Complexity:- O(n)
# Space Complexity:- O(h) h=height of the tree
# Approach:- Maintain a sum of the path leading to the leaf node when we reach the leaf node return it, We want all the sum of the path leading to the 
# leaf node in a tree, so we add it together
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        def sn(root,sumn):
            if root is None:
                return 0
            # sum of a path leading to the leaf node
            if root.left is None and root.right is None:
                return sumn*10+root.val
            # sum of all the paths leading to the leaf node
            return sn(root.left,sumn*10+root.val)+sn(root.right,sumn*10+root.val)
        return sn(root,0)
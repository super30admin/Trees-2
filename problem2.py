# problem 2 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def helper(self,root_node,count):
        if root_node is None:
            return 
        count = (count * 10) + root_node.val
        if root_node.left is None and root_node.right is None:
            self.count+=count
        self.helper(root_node.left,count)
        self.helper(root_node.right,count)

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.count = 0 
        self.helper(root,0)
        return self.count
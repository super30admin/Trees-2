from typing import List, Optional

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if len(postorder) == 0:
            return None
        
        root_val = postorder[-1]  # get root from postorder
        root = TreeNode(root_val)  # make a new node
        root_idx = inorder.index(root_val)  # find root in inorder
        
        in_left = inorder[:root_idx]  # split inorder to left and right sub arrays
        in_right = inorder[root_idx+1:]
        
        post_left = postorder[:len(in_left)]  # using len of in_left, build post_left
        post_right = postorder[len(in_left):-1]  # similarly build post_right
        
        root.left = self.buildTree(in_left, post_left)  # recursively build the left subtree
        root.right = self.buildTree(in_right, post_right)  # recursively build the right subtree
        
        return root

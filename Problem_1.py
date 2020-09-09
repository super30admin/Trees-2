
# 106. Construct Binary Tree from Inorder and Postorder Traversal


# Code:

# Approach: Similar to prev tree constructs:
# here we are given postorder: root is at the end!

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if not inorder or not postorder:
            return
        
        root = TreeNode(postorder.pop())
        
        idx = inorder.index(root.val)
        
        root.right = self.buildTree(inorder[idx+1:], postorder)
        root.left = self.buildTree(inorder[:idx], postorder)
        
        
        return root

# Time complexity: O(N) + O(H)  Height of the tree, number of elements in the array.
# Space complexity: O(1) No extra space 
# Accepted on Leetcode: Yes.
# Construct Binary Tree from Preorder and Inorder Traversal

# Time Complexity : O(N*N)
# Space Complexity : O(N*N)
# Did this code successfully run on Leetcode : Yes with Runtime: 176 ms and Memory Usage: 89 MB
# Any problem you faced while coding this : After Class No
# Your code here along with comments explaining your approach :
# Approach
"""
Using Recursive approach and finding root using preorder array (Root->Left->Right)
Index in inorder array (Left->Root->Right) is found. To build left subtree using
preorder left and preorder right and to build right subtree using 
Inorder left and Inorder Right.

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) > 0:
            root = TreeNode(preorder[0])      # If preorder is null return None  
            ind = inorder.index(preorder[0])

            Inleft = inorder[0:ind]
            Inright = inorder[ind+1:len(inorder)] 
            Preleft = preorder[1:1+len(Inleft)]
            Preright = preorder[1+len(Inleft):len(preorder)]

            root.left = self.buildTree(Preleft, Inleft)
            root.right = self.buildTree(Preright, Inright)

            return root
        return None
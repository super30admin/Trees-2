"""
Given inorder and postorder traversal of a tree, construct the binary tree.

Time = O(n), n = number of nodes in a tree
Space: worst = O(n), average(height balanced tree) = O(logn) where n = number of nodes in a tree
Successfully excecuted on leetcode

Approach(Recursion) ---
1. Get the root from postorder's last element.
2. Get index of root in inorder to partition the left and right subtree
3. All element left to the root_idx in inorder should be recursively used to build left subtree, same goes for right subtree

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class ConstructBST:
    def buildTree(self, inorder, postorder):
        if not inorder or not postorder:
            return None
        
        root = TreeNode(postorder.pop())
        root_idx = inorder.index(root.val)

        root.left = self.buildTree(inorder[:root_idx], postorder)
        root.right = self.buildTree(inorder[root_idx+1:], postorder)

        return root
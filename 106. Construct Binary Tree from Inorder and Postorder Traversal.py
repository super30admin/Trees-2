"""
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        """The last element of the postorder is root.
        Seach the element took from postorder in inorder, 
        the left part of the val is leftsubtree and rigt part is right subtree
        and recursiveely process the left and right subtree"""
        
        # Run TIme Complexity : O(N)
        # SPace Complexity : O(N)
        def helper(left = 0, right = len(inorder)):
            if left == right :
                return
            val = postorder.pop()
            root  = TreeNode(val)
            idx = idx_map[val]
            root.right = helper(idx+1, right)
            root.left = helper(left, idx)
            return root
        # post_idx = len(postorder)-1
        idx_map = {val: idx for idx, val in enumerate(inorder)}
        return helper()
            
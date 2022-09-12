"""
Time Complexity  : O(n^2) where n is the number of elements in the tree. n^2 because for every node we are finding out the root index in inorder traversal array
Space Complexity : O(n^2) where n is the number of elemenets in the tree. For every node we are creating 4 different new arrays.
Did this code successfully run on Leetcode : Yes

Three line explanation of solution in plain english:
postorder traversal's last node is always the root node.
1. Find the root using Postorder traversal
2. Calculate the inOrderLeft, postOrderLeft, inOrderRight, postOrderRight arrays.
3. Find the left and right elements of the root by calling buildTree function in recursive manner.
"""
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
        
        rootVal = postorder[-1]
        root = TreeNode(rootVal)
        idx = 0
        
        for i in range(len(inorder)):
            if inorder[i] == rootVal:
                idx = i
                break
    
        inL = inorder[0:idx]
        postL = postorder[0:idx]
        inR = inorder[idx+1:len(inorder)]
        postR = postorder[idx:len(postorder)-1]
        
        root.left = self.buildTree(inL, postL)
        root.right = self.buildTree(inR, postR)
        
        return root
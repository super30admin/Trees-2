"""
Time Complexity  : O(n) where n is the number of elements in the tree. 
Space Complexity : O(n) where n is the number of elemenets in the tree.
Did this code successfully run on Leetcode : Yes

Three line explanation of solution in plain english:
Postorder traversal's last node is always the root node.
1. Find the root using Postorder traversal
2. Calculate the inOrderLeft, postOrderLeft, inOrderRight, postOrderRight arrays using pointers instear of creating them everytime.
3. Find the left and right elements of the root by calling buildTree function in recursive manner.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.hashmap = {}
        self.idx = 0
    
    def helper(self, postorder, start, end):
        #base
        if start > end:
            return None
        
        #Logic
        rootVal = postorder[self.idx]
        self.idx -= 1
        rootIdx = self.hashmap[rootVal]
        root = TreeNode(rootVal)
        
        root.right = self.helper(postorder, rootIdx+1, end)
        root.left = self.helper(postorder, start, rootIdx-1)
        
        return root
        
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if len(postorder) == 0:
            return None
        
        for idx in range(len(inorder)):
            self.hashmap[inorder[idx]] = idx
        
        self.idx = len(postorder) - 1
        return self.helper(postorder, 0, len(inorder)-1)
        
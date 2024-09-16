"""
Time Complexity - O(N^2)
Space Complexity - O(N)

Runs on leetcode

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
        
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        
        if len(postorder) == 0: 
            return None
        
        root_val = postorder[-1]
        root = TreeNode(root_val)
        for idx in range(len(inorder)):
            if inorder[idx] == root_val :
                break
        
        inorder_left = inorder[0:idx]
        inorder_right = inorder[idx+1:]
        postorder_left = postorder[0:idx]
        postorder_right = postorder[idx:len(postorder)-1]
        
        l = self.buildTree(inorder_left,postorder_left)
        r = self.buildTree(inorder_right,postorder_right)
        
        root.left = l
        root.right = r
        
        return root
        

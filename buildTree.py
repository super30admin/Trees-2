# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    """
    Time Complexicity: O(n)
    Space Complexicity: O(n)
    where n are the number of elements in the tree
    
    Description: Construct Binary Tree from Inorder and Postorder Traversal
    
    Approach:
    1. create a hashmap using indices and values of the preorder traversal
    2. use start and end indices for each right and left subtree recursively to create a BST
    
    """
    
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        
        assert len(inorder) == len(postorder), "Both lists should have equal lengths"
        if len(inorder) == 0: return None
        
        self.idx = len(postorder) - 1; self.root_dict = {}
        for value, key in enumerate(inorder):
            self.root_dict[key] = value
        
        return self.helper(postorder, 0, len(postorder) - 1)
    
    def helper(self, postorder, str_idx, end_idx):
        
        # Base
        if str_idx > end_idx: return None
        
        # Logic
        root_val = postorder[self.idx]
        root = TreeNode(root_val)
        root_idx = self.root_dict[root_val]
        self.idx -= 1

        root.right = self.helper(postorder, root_idx + 1, end_idx)        
        root.left = self.helper(postorder, str_idx, root_idx - 1)
        
        return root

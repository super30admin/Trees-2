'''
Approach 1: Recursively
TC : O(n)
SC : O(n) for recursive stack
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        
        #base condition
        if not inorder:
            return 
        
        #finding the root node's index in inorder traversal as root node is the last value in post order
        root_val = postorder.pop()
        idx_root = inorder.index(root_val)
        root = TreeNode(root_val)
        
        #left sub-tree
        root.left = self.buildTree(inorder[:idx_root], postorder[:idx_root])
        #right sub-tree
        root.right = self.buildTree(inorder[idx_root+1:], postorder[idx_root:])
        
        return root
# 106. Construct Binary Tree from Inorder and Postorder Traversal
# https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time complexiety: O(n)
# Space complexiety: O(n)
class Solution:
    def __init__(self):
        self.p = 0
    
    def _helper(self, inorder, postorder, inorder_hash, start, end):
        # Base case
        if start > end or self.p < 0:
            return
        
        root = TreeNode(postorder[self.p])
        
        inorderIdx = inorder_hash[postorder[self.p]]
        self.p -= 1
        
        # Doing right first as we consider is reverse of preorder
        root.right = self._helper(inorder, postorder, inorder_hash, inorderIdx+1, end)
        root.left = self._helper(inorder, postorder, inorder_hash, start, inorderIdx-1)
        
        
        return root
    
    def buildTree(self, inorder, postorder):
        inorder_hash = dict()
        
        for idx, i in enumerate(inorder):
            inorder_hash[i] = idx
        self.p = len(inorder)-1
        return self._helper(inorder, postorder, inorder_hash, 0, len(inorder)-1)

obj = Solution()
print(obj.buildTree([9,3,15,20,7],[9,15,7,20,3]))
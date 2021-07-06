"""
// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

--> the last element in postorder is always the root
--> we find the root from postorder and use inorder to get the left and right subtrees

// Your code here along with comments explaining your approach
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    post_ind = 0 #GLOBAL, to iterate over postorder, will be set to last index in buildTree function
    
    def helper(self,in_map, postorder, inorder, in_start, in_end):
        
        if in_start> in_end or self.post_ind == -1:
            return None
        root = TreeNode(postorder[self.post_ind])
        
        self.post_ind -= 1
        
        in_idx = in_map[root.val]
        
        root.right  = self.helper(in_map, postorder, inorder, in_idx + 1, in_end) #go for right child first, right child is encountered before left child in postorder
        root.left = self.helper(in_map, postorder, inorder, in_start, in_idx - 1)
        
        return root
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        
        in_map = dict()
        
        self.post_ind = len(postorder) - 1
        
        for i, val in enumerate(inorder):
            in_map[val] = i 
        
        return self.helper(in_map, postorder, inorder, 0, len(inorder) - 1)
            
            
            
#Time Complexity : O(N)
#Space Complexity : O(N)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        
        return self.helper(inorder,postorder)
    
    def helper(self,inorder,postorder):
        if not inorder:
            return None
        
        val = postorder.pop()
        mid = inorder.index(val)
        right = self.helper(inorder[mid+1:],postorder)
        left = self.helper(inorder[:mid],postorder)
        
        return TreeNode(val,left,right)
        
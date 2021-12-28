# Time Complexity : O(n)
# Space Complexity : O(N)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 
# Your code here along with comments explaining your approachclass Solution:

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        def helper(postorder, inorder):
            if not postorder:
                return None
            
            root = TreeNode(postorder[-1])
            
		
            indx = inorder.index(postorder[-1])
            
            root.left = helper(postorder[:indx], inorder[:indx])
            root.right = helper(postorder[indx:-1], inorder[indx+1:])
            
            return root
        
        return helper(postorder, inorder)
        
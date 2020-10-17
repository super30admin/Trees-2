# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        
        
        map_inorder = {}
        for i, val in enumerate(inorder): 
            map_inorder[val] = i
        
        def helper(low, high):
            
            if low > high: 
                return None
            
            x = TreeNode(postorder.pop())
            mid = map_inorder[x.val]
            
            x.right = helper(mid+1, high)
            x.left = helper(low, mid-1)
            
            return x
        
        return helper(0, len(inorder)-1)
# Time Complexity : O(n)
# Space Complexity : O(n) - recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

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
        curr = TreeNode()
        curr.val = postorder[len(postorder)-1]
        root_index = inorder.index(curr.val)
        curr.left = self.buildTree(inorder[:root_index], postorder[:root_index])
        curr.right = self.buildTree(inorder[root_index+1:], postorder[root_index:-1])
        return curr
        
        
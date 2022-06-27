# Time Complexity : O(n)
# Space Complexity : O(n) height of the tree as recursion use reursive call stack 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :No
# # class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not inorder:
            return
        last_node=postorder.pop()
        root=TreeNode(last_node)
        mid_idx=inorder.index(last_node)
        
        root.right=self.buildTree(inorder[mid_idx+1:],postorder)
        root.left=self.buildTree(inorder[:mid_idx],postorder)
       
        return root
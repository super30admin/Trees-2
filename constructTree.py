# Time Complexity : O(n)
# Space Complexity : O(n)
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
        def construct_tree(left,right):
            if left > right:
                return None
            root_val = postorder.pop()
            root = TreeNode(root_val)
            root.right = construct_tree(inorder_idx[root_val]+1,right)
            root.left = construct_tree(left,inorder_idx[root_val]-1)
            return root
        inorder_idx = {val:ind for ind,val in enumerate(inorder)}
        return construct_tree(0,len(postorder)-1)

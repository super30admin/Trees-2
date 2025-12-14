# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
#The last element in postorder is always the root of the current subtree.
# Use inorder to find the root index, which divides the left and right subtrees.
# Recursively build the right subtree first, then the left, using postorder from the end to the start.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.idx = len(postorder)-1
        inorder_map = {val:i for i,val in enumerate(inorder)}
        return self.helper(postorder,0,len(inorder)-1,inorder_map)
    def helper(self, postorder, start, end, inorder_map):
        if start>end:
            return None
        
        root_val = postorder[self.idx]
        self.idx -= 1
        root = TreeNode(root_val)
        root_idx = inorder_map[root_val]

        root.right = self.helper(postorder,root_idx+1,end,inorder_map)
        root.left = self.helper(postorder,start,root_idx-1,inorder_map)
        return root
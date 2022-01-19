
# Recursive Approach without dictionary
# // Time Complexity : O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        
        if not postorder or not inorder:
            return None

        if len(postorder) == 1:
            return TreeNode(postorder[-1])
        
        root = TreeNode(postorder[-1])
        root_index = inorder.index(postorder[-1])
        
        ####They are from the same tree，the number of nodes to build the left and right tree is the same. Key points.
        root.right = self.buildTree(inorder[root_index + 1:], postorder[root_index:-1])
        root.left = self.buildTree(inorder[:root_index], postorder[:root_index],)
        
        return root
        
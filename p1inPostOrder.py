
"""
given post and preorder, find BST

// Time Complexity : O(N^2)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not inorder or not postorder:
            return None


        root = TreeNode(postorder.pop())
        inorderIndex = inorder.index(root.val) #mid index


        root.right = self.buildTree(inorder[inorderIndex+1:], postorder)
        root.left = self.buildTree(inorder[:inorderIndex], postorder)

        return root
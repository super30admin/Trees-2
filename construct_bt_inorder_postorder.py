# // Time Complexity : O(n) where n is the number of nodes in the tree
# // Space Complexity : O(h) where h is the height of the tree
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if not inorder or not postorder: return None
        
        node = postorder[-1]
        idx = -1
        for i in range(len(inorder)):
            if inorder[i] == node:
                idx = i
                
        postorder_left = postorder[:idx]
        postorder_right = postorder[idx:-1]
        inorder_left = inorder[:idx]
        inorder_right = inorder[idx+1:]
        
        root = TreeNode(node)
        root.left = self.buildTree(inorder_left,postorder_left)
        root.right = self.buildTree(inorder_right,postorder_right)
        return root
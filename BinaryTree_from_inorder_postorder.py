// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach: using recursion


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        
        if inorder == None or len(inorder) == 0:
            return None
        
        ind = inorder.index(postorder[-1])
        root = TreeNode(postorder[-1])
        
        root.right = self.buildTree(inorder[ind+1:], postorder[ind:-1])
        root.left = self.buildTree(inorder[0:ind], postorder[0:ind])
        
        return root

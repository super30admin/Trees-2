# Time Complexity - O(n)
# Space Complexity - O(n)
#Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        postIndex = len(postorder) - 1
        dict = {}
        for x in range(len(inorder)):
            dict[inorder[x]] = x
        
        def helper(start, end):
            nonlocal postIndex
            
            if start > end:
                return None
            newnode = TreeNode(postorder[postIndex])
            postIndex -= 1
            
            newnode.right = helper(dict[newnode.val] + 1, end)
            newnode.left = helper(start, dict[newnode.val] - 1)
            
          
            return newnode 
        
        return helper(0, len(inorder) - 1)
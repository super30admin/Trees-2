# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        """
        Similar to last problem. Traverse on postorder and find it on inorder
        """
        if not inorder or not postorder or len(postorder) == 0 or len(inorder) != len(postorder):
            return None
        length = len(postorder)
        return self.helper(postorder, inorder, 0, length, 0, length)
        
    def helper(self, postorder, inorder, inSt, inEnd, postSt, postEnd):
        if inSt >= inEnd or postSt >= postEnd:
            return None 
        curr = TreeNode(postorder[postEnd-1])
        it = inorder.index(postorder[postEnd-1])
        diff = it - inSt
        curr.left = self.helper(postorder, inorder, inSt, inSt+diff, postSt, postSt+diff)
        curr.right = self.helper(postorder, inorder, inSt + diff + 1, inEnd, postSt+diff, postEnd-1)
        
        return curr
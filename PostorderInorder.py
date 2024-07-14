#// Time Complexity : O(n) 
# // Space Complexity : O(n)   
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : Yes i was not able to get the pointers solution at first but got it.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        dicti = {}
        for i,j in enumerate(inorder):
            dicti[j] = i
        end =  len(inorder) - 1
        start = 0
        postorderind = len(postorder) - 1
        def helper(start,end):
            nonlocal postorderind,postorder
            if  start > end:
                return None
            rootval = postorder[postorderind]
            postorderind -= 1
            rootind = dicti[rootval] 
            root = TreeNode(rootval)
            root.right = helper(rootind+1,end)
            root.left = helper(start,rootind-1)
            return root
        return helper(start,end)


# Approach:
# Similar to the preorder and indorder tree but the only difference is that here we traverse the right tree first.
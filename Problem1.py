# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.pos = 0
        self.search = {}
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        self.pos = len(postorder) - 1
        for i in range(len(inorder)):
            self.search[inorder[i]] = i
        return self.helper(postorder,0,len(postorder)-1)
    
    def helper(self,post,l,r):
        if l > r:
            return None
        root = TreeNode(post[self.pos])
        ind = self.search[post[self.pos]]
        self.pos -= 1
        root.right = self.helper(post,ind+1,r)
        root.left = self.helper(post,l,ind-1)
        return root
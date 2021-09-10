# // Time Complexity :O(n) 
# // Space Complexity :O(h)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach






# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.dict={}
        self.idx=0
        
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        start=0
        end=len(inorder)-1
        self.idx=len(postorder)-1
        for i in range(len(inorder)):
            self.dict[inorder[i]]=i
        root=self.inorder(postorder,start,end)
        return root
    def inorder(self,postorder,start,end):
        if start>end:
            return None
        rootindx = self.dict[postorder[self.idx]]
        root=TreeNode(postorder[self.idx])
        self.idx=self.idx-1
        root.right=self.inorder(postorder,rootindx+1,end)
        root.left=self.inorder(postorder,start,rootindx-1)
        return root
        
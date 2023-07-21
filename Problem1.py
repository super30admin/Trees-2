#Time Complexity :O(n)
#Space Complexity :O(h)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.inMap={}
        self.rootId=len(postorder)-1
        for i in range(len(inorder)):
            self.inMap[inorder[i]]=i
        return self.helper( postorder,0,len(inorder)-1)

    def helper(self, postorder, start, end):
        if start>end:
            return None
       
        rootVal=postorder[self.rootId]
        self.rootId-=1
        
        id=self.inMap.get(rootVal)
        root=TreeNode(rootVal)
        
        root.right=self.helper(postorder,id+1,end)
        root.left=self.helper(postorder,start,id-1)

        return root

        




#time - n,space - n
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.hmap={}
        self.idx=0
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.idx=len(postorder)-1
        for i in range(len(inorder)):
            if inorder[i] not in self.hmap:
                self.hmap[inorder[i]]=i
        return self.helper(0,postorder,0,len(inorder)-1)
    def helper(self,rootidx,postorder,start,end):
        #base
        if start>end:
            return None
        #logic
        root=TreeNode(postorder[self.idx])
        rootidx=self.hmap[postorder[self.idx]]
        self.idx-=1
        print(self.idx,start,end)
        
        root.right=self.helper(rootidx,postorder,rootidx+1,end)
        root.left=self.helper(rootidx,postorder,start,rootidx-1)
        return root
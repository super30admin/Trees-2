# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.idx=len(postorder)-1
        self.in_map=dict()
        for i in range(len(inorder)):
            self.in_map[inorder[i]]=i
        return self.helper(postorder,0,len(inorder)-1)
    def helper(self,postorder: List[int],start:int,end:int):
        if start>end: return 
        rootval=postorder[self.idx]
        # if self.idx>=len(postorder)-1:
        #     self.idx=-1
        self.idx-=1
        rootIdx=self.in_map[rootval]
        root=TreeNode(rootval)
        root.right=self.helper(postorder,rootIdx+1,end)
        root.left=self.helper(postorder,start,rootIdx-1)
        return root
               
        
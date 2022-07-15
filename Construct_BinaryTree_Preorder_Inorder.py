# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        preorder=collections.deque(preorder)
        lookup={value:index for index,value in enumerate(inorder)}
        
        def rec(start,end):
            if start>end:
                return
            else:
                cand=preorder.popleft()
                root=TreeNode(cand)
                middle=lookup[cand]
                
                root.left=rec(start,middle-1)
                root.right=rec(middle+1,end)
                
                return root
            
        return rec(0,len(preorder)-1)
                
        
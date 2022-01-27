# Leetcode Execution: YES
# TC: O(n)
# SC: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.index=None
        self.mapp={}
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        # we first keep index to track preorder root nodes and mapp hash map for index look up from inorder array.
        for i,x in enumerate(inorder):
            self.mapp[x]=i
        self.index=len(postorder)-1
        return self.helper(postorder,0,self.index)
    
    
    
    # we will maintain start and end pointer to reduce space complexity and recursively build right tree first then sub sub trees by calling helper for root.right and root.left and return the root to above node there by creating the connection 
    def helper(self,postorder, start,end):
        # print(inorder, self.index)
        if start>end:
            return None
        
        
        root=TreeNode(postorder[self.index])
        self.index-=1
        root.right=self.helper(postorder, self.mapp[root.val]+1,end)
        root.left=self.helper(postorder, start,self.mapp[root.val]-1)
        return root
        
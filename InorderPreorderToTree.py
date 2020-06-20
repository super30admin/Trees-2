# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.map1={}
        self.index=None
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        for i in range(len(inorder)):
            self.map1.put(inorder[i],i)
        return helper(preorder,inorder,0,len(inorder)-1)
    
    def helper(preorder,inorder,start,end):
        if start>end or index==len(preorder):
            return None
        TreeNode root=TreeNode(preorder[index])
        inIdx=self.map1.get(root.val)
        self.index+=1
        root.left=self.helper(preorder,inorder,start,inIdx-1)
        root.left=self.helper(preorder,inorder,inIdx+1,end)
        return root
        
#space is O(n)
#time complexity is O(n)

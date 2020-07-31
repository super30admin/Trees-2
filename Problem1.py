#Trees-2:
#Problem1 : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
#All test cases passed on Leetcode
#Time Complexity-O(N)
#Space Complexity-O(N)

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
       

class Solution:
    def __init__(self):
        self.idx = 0
        self.dict1 = {}
       
        
        
    def helper(self,postorder,inorder,start,end):
        #base
    
        if  start>end:
            return
        
        #find the root index in the inorder traversal
        #print(idx)
        rootidx=self.dict1[postorder[self.idx]]
        #print(rootidx)
        root=TreeNode(postorder[self.idx])
        self.idx-=1
        root.right=self.helper(postorder,inorder,rootidx+1,end)
        root.left=self.helper(postorder,inorder,start,rootidx-1)
        
        return root
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        self.idx=len(postorder)-1
        for i in range(len(inorder)):
            self.dict1[inorder[i]]=i
        print(self.dict1)
        return self.helper(postorder,inorder,0,len(inorder)-1)
        
        
        
















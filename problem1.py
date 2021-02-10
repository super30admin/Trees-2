// Time Complexity : O(n)
// Space Complexity : O(maximum depth+ dictionary space)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        self.dictionary={}                      
        self.postIndex=len(postorder)-1
        for i in range(len(inorder)):
            self.dictionary[inorder[i]]=i
        return self.buildNewTree(inorder,postorder,0,len(inorder)-1)
    
    def buildNewTree(self,inorder,postorder,inStart,inEnd):
        if inStart>inEnd:
            return None
        
        root=TreeNode(postorder[self.postIndex])
        self.postIndex-=1
        
        #Root ,Right, left
        index=self.dictionary[root.val]
        
        root.right= self.buildNewTree(inorder,postorder,index+1,inEnd)
        root.left=self.buildNewTree(inorder,postorder,inStart,index-1)
        return root

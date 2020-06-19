#106. Construct Binary Tree from Inorder and Postorder Traversal
#Time Complexity : O(n) 
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes

class Solution:
    index = -1
    mapp = {}
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        self.index = len(postorder)-1
        if not inorder or not postorder:
            return None
        for i in range(len(inorder)):
            self.mapp[inorder[i]] = i
        return self.helper(postorder,inorder,0,len(inorder)-1)
    def helper(self, postorder, inorder,start,end):
        if start > end or self.index < 0 :
            return None
        root = TreeNode(postorder[self.index])
        indx = self.mapp[root.val]
        self.index -= 1
        root.right = self.helper(postorder,inorder,indx + 1, end)
        root.left = self.helper(postorder,inorder,start,indx-1)
        
        return root
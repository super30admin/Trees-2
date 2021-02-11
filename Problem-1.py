#Time Complexity :O(n) 
#Space Complexity :o(n) hashmap 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    hmap=None
    idx=None
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        self.idx=len(inorder)-1
        self.hmap={}
        
        for i in range(len(inorder)):
            self.hmap[inorder[i]]=i

        return self.helper(inorder,postorder,0,len(inorder)-1)
    
    def helper(self,inorder,postorder,start,end):
        #base
        if(start>end or self.idx<0):
            return None
        #logic
        rootVal=postorder[self.idx]
        self.idx-=1
        root=TreeNode(rootVal)
        inoIndx=self.hmap[rootVal]
        root.right=self.helper(inorder,postorder,inoIndx+1,end)
        root.left=self.helper(inorder,postorder,start,inoIndx-1)
        
        return root
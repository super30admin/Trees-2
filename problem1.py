# Time Complexity = O(n)
#Space Complexity = O(n)
class Solution:
    hashmap = {}
    index = 0
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if(inorder==None or postorder== None or len(postorder)==0):
            return None
        for i,v in enumerate(inorder):
            self.hashmap[v] = i
        self.index= len(postorder)-1
        return self.helper(postorder,0,len(postorder)-1)
    
    def helper(self,postorder,start,end):
        if(start>end):
            return None
        rootVal = postorder[self.index]
        self.index-=1
        rootidx = self.hashmap[rootVal]
        root = TreeNode(rootVal)
        root.right = self.helper(postorder,rootidx+1,end)
        root.left = self.helper(postorder,start,rootidx-1)
        
        return root
        
        
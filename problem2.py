#Time Complexity O(N)
#Space Complexity O(N)
class Solution:
    def checktree(self,l,r):
        if l == None and r ==None:
            return True
        if l==None and r !=None:
            return False
        if l!=None and r ==None:
            return False
        if l.val!=r.val:
            return False
        return self.checktree(l.left,r.right) and self.checktree(l.right,r.left)
    
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.checktree(root.left,root.right)
        
        
        

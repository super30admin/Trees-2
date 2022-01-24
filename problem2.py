# Time Complexity = O(n)
#Space Complexity = O(n)
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if(root==None):
            return 0
        
        return self.helper(root,0)

        
    def helper(self,root,curr):
        if(root==None):
            return 0
        elif(root.right==None and root.left==None):
            return curr*10 + root.val
        else:
            return self.helper(root.left,curr*10+root.val) + self.helper(root.right,curr*10+root.val)
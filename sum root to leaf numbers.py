class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.sum=0
        self.helper(root,0)
        return self.sum

    def helper(self,root: Optional[TreeNode],currNum: int)-> int:

        if root==None:
            return
        
        currNum=currNum*10+root.val
        if(root.left==None and root.right==None):
            self.sum=self.sum+currNum
        
        self.helper(root.left,currNum)
        self.helper(root.right,currNum)
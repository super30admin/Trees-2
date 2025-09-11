def sumNumbers(self, root: Optional[TreeNode]) -> int:
    self.result=0
    self.helper(root,0)
    return self.result

def helper(self,root,curr):
    if root is None:
        return
    curr=curr*10+root.val
    self.helper(root.left,curr)
    if root.left is None and root.right is None:
        self.result+=curr
    self.helper(root.right,curr)
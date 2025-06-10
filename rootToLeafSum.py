# TC: O(n)
# SC: O(h) -> recursion stack
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        result=0
        def helper(root, n):
            nonlocal result
            if root==None:
                return

            helper(root.left, n*10 + root.val)
            
            helper(root.right, n*10 + root.val)
            if root.left==None and root.right==None:
                result+=n*10 + root.val
                return
            return
        
        helper(root, 0)
        return result
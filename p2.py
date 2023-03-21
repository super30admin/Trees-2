class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        

        def getSum(root: Optional[TreeNode],currNum) -> None:
            if root is None:
                return
            
            #logic
            nonlocal ans
            if root.left == None and root.right == None:
                ans += currNum * 10 + root.val
            print(currNum)
            getSum(root.left, currNum * 10 + root.val)
            getSum(root.right,currNum * 10 + root.val)

    
        ans = 0
        getSum(root,0)
        return ans
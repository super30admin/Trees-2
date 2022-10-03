# TC: O(n)
# SC: O(h)
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return
        summ = 0
        stack = []
        nums = []
        num = 0
        while root != None or len(stack) != 0:
            while root != None:
                num = 10*num + root.val
                stack.append(root)
                nums.append(num)
                root = root.left
            
            root = stack.pop()
            num = nums.pop()
            if root.left == None and root.right == None:
                summ  = summ + num     
            root = root.right
        return summ

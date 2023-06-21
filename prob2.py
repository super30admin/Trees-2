# Time Complexity :O(n)
# Space Complexity :O(h) - height of tree
# Leet Code: Yes

class Solution:
    res = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:

        def helper(root, num):
            # base case
            if root == None:
                return

            num = root.val + num*10
            if root.left == None and root.right == None:
                self.res = self.res + num
            helper(root.left, num)
            helper(root.right, num)
            

        
        helper(root, 0)
        return self.res
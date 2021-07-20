#Space:O(1)
#Time:O(n)
class Solution:
    def __init__(self):
        self.ans = 0
    def sumNumbers(self, root: TreeNode) -> int:
        
        def helper(root, val):
            if not root:
                return
            helper(root.left, 10*val+root.val)
            helper(root.right, 10*val+root.val)
            if not root.left and not root.right:
                print(val)
                self.ans+=10*val+root.val
        helper(root, 0)
        return self.ans
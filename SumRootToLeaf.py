#Time Complexity: O(N)
#Space Complexity: O(h)
#Successfully ran on leetcode

class Solution:
    def __init__(self):
        self.total = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.recurse(root,0)
        return self.total
    def recurse(self,root,num):
        if not root:
            return
        self.recurse(root.left,num*10+root.val)
        if not root.left and not root.right:
            self.total+=num*10+root.val
        self.recurse(root.right,num*10+root.val)
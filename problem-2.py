#Time Complexity :O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : yes
class Solution:
    def __init__(self):
        self.s = 0
        
    def _helper(self, root, num):
        if root:
            num = 10*num + root.val
            if root.left == None and root.right == None:
                self.s += num

            self._helper(root.left,num)
            self._helper(root.right,num)
    
    def sumNumbers(self, root) -> int:
        self._helper(root,0)
        return self.s
        
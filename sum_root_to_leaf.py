# Time Complexity : Add - O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode : Yes.

# Any problem you faced while coding this : No

'''
1. I have used demonstarted both recursive and iterative approach
2. Both involves traversing inorder while maintaing the digit accumulation
'''
from collections import deque
class Solution:
    global_sum = 0
    def sumNumbers(self, root: TreeNode) -> int:
        
        # return self._helper(root,0)
        return self._iterative(root,0)
    
    def _helper(self, root, sum_):
        
        if root is None:
            return 0
        
        self._helper(root.left, (sum_*10)+root.val)
    
        if root.left is None and root.right is None:
            self.global_sum += (sum_*10)+root.val
            
        self._helper(root.right, (sum_*10)+root.val)
        
        return self.global_sum
    
    def _iterative(self, root, sum_):
        
        stack = deque()
        
        while stack or root is not None:
            while root is not None:
                
                sum_ = (sum_*10) + root.val
                stack.append((root, sum_))
                root = root.left
                
            root, sum_ = stack.pop()
            if root.left is None and root.right is None:
                self.global_sum += sum_
            root = root.right
        return self.global_sum
                
            
                
                
        
        
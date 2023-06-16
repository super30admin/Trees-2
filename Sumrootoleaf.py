# Time Complexity : O(n) for each operation.
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to calculate the current number at every node and sum it with a global variable once it reaches its leaf.

class Solution:
    def __init__(self):
        self.ts=0;
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        s=self.helper(root, 0)
        return self.ts

    def helper(self, root, s):
        if root == None:
            return 
        s=s*10+root.val
        if(root.left == None and root.right == None):
            self.ts+=s

        self.helper(root.left,s)
        self.helper(root.right, s)
        return 
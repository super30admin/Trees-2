# Time Complexity :O(N)
# Space Complexity :O(LogN) recursion stack space
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approac



class Solution:
    def helper(self, root, curr_num):
        # base
        if(root==None):
            return 0
        if(root.left==None and root.right==None):
            return curr_num*10+root.val
        # logic
        curr_num=10*curr_num+root.val
        return self.helper(root.left, curr_num)+self.helper(root.right, curr_num)
        # return

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        return self.helper(root, 0)
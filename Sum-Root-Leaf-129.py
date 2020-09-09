# Time Complexity : O(n)
# Space Complexity : O(h) height of tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach 

class Solution(object):
    
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.output = 0
        
    
        def helper(root, prev):
            if root == None:
                return
            curr = prev * 10 + root.val
            
            if root.left is None and root.right is None:
                self.output += curr
                return
            
            helper(root.left, curr)
            helper(root.right, curr)
        
        helper(root, 0)
        return self.output

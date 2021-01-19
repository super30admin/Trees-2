# Time Complexity : O(n)
# Space Complexity : O(n) considering stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# I do inorder traversal and and add to result whenever I react a leaf node.
# At each level we multiply current sum by 10 and add current value

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        self.result = 0
        def helper(current, rSum):
            #Terminating condition
            if not current:
                return 0
            
            if not current.left and not current.right:
                self.result += rSum*10 + current.val
            
            #Inorder Operations
            rSum = rSum*10+current.val
            helper(current.left, rSum)
            helper(current.right, rSum)
            
        helper(root, 0)
        return self.result
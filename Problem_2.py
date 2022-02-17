# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        def recur(root, low, high):
            if root == None:
                return True
            
            if root.val >= high or root.val <= low:
                return False
            
            return recur(root.left, low, root.val) and recur(root.right, root.val, high)
        return recur(root, float("-inf"), float("inf"))
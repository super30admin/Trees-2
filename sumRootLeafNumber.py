# Time Complexity : O(n)
# Space Complexity : O(h) Stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        result = 0
        if not root: return result
        return self.sum(root,result,0)

    def sum(self,root,result,val):
        if not root: return result
        if not root.left and not root.right:
            result = result + (val*10+root.val)
            return result
        result = self.sum(root.left, result, val*10+root.val)
        result = self.sum(root.right, result, val*10+root.val)
        return result
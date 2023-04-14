# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root,0)
        return self.result

    def helper(self, root, currnum):
        if root == None:
            return None
        
        currnum *= 10
        currnum += root.val

        if root.left == None and root.right == None:
            self.result += currnum

        self.helper(root.left,currnum)
        self.helper(root.right,currnum)


        """
        :type root: TreeNode
        :rtype: bool
        """
        
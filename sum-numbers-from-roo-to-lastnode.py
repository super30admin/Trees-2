# Time Complexity : O(n)
# Space Complexity : O(n), recursion call stack which is eqaul to the height of the tree
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :No
# 
# # Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        sumNum=0
        def helper(node,sumNum):
            if not node:
                return 0
            sumNum=sumNum*10+node.val
            if not node.left and not node.right:
                return sumNum
            node.left=helper(node.left,sumNum)
            node.right=helper(node.right,sumNum)
            return node.left+node.right
        return helper(root,sumNum)
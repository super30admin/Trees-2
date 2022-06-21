# time complexity is o(n), where n is the size of the input
# space complexity is o(n), Recursive stack space
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    sums = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.summing(root, 0)
        return self.sums
        
    def summing(self, root, currsum):
        if(not root):
            return
        self.summing(root.left, currsum*10 + root.val)
        if(root and root.left == None and root.right == None):
            # currsum = currsum*10 + root.val
            self.sums += currsum*10 + root.val
        self.summing(root.right, currsum*10 + root.val)
        
        
        

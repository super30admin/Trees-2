# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#time complexity: O(n)
#space complexity: O(h)
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.summ=0
        if root==None: return 0
        
        def helper(root, currsum):
            if root==None:
                return
            if root.left==None and root.right==None:
                self.summ=self.summ+(currsum*10)+root.val
                
            helper(root.left, (currsum*10)+root.val)
            helper(root.right, (currsum*10)+root.val)
            
        helper(root, 0)
        return self.summ
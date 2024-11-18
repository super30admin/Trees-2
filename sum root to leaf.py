#TC: O(n)
#SC: O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.globalSum = 0
        def xyz(root, currSum):
            if not root:
                return
            
            if root.left == None and root.right == None:
                self.globalSum += currSum * 10 + root.val

            xyz(root.left, currSum * 10 + root.val)
            xyz(root.right, currSum * 10 + root.val)
        
        xyz(root, 0)
        return self.globalSum

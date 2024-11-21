# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        cursum, result = 0, 0
        def helper(node, cursum):
            if not node:
                return
            if not node.left and not node.right:
                nonlocal result
                cursum = cursum*10 + node.val
                result += cursum 
                return
            
            cursum = cursum*10 + node.val

            helper(node.left, cursum)

            # cursum = cursum // 10       #need to do this while going to the right 
            
            helper(node.right, cursum)


            return

        helper(root, 0)
        return result

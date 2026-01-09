# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:



        def helper(root, curr_sum):
            curr_sum=curr_sum*10+root.val

            if(root.left == None and root.right == None):
                self.result+=curr_sum


            if(root.left):
                helper(root.left, curr_sum)

            if(root.right):
                helper(root.right,curr_sum)


        self.result = 0

        helper(root,0)

        return self.result

# TC: O(n)
# SC: O(h)
# Does this code run on Leetcode: yes
# Did you face any difficulty while coding this: No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def  sumNumbers(node, pnum):
            if node == None:
                return 0
            pnum = pnum*10 + node.val
            if(node.left == None and node.right== None):
                return pnum
            return sumNumbers(node.left, pnum) + sumNumbers(node.right, pnum)
        return sumNumbers(root, 0)
    
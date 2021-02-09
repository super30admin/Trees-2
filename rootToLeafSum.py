#TimeComplexity:O(N) 
#SpaceComplexity: O(Depth)
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    #Sum=0
    def sumNumbers(self, root: TreeNode) -> int:
        Sum=0
        def findSum(cur,count):
            nonlocal Sum
            count=count*10+cur.val            
            if cur.left is None and cur.right is None:
                Sum+=count
            if cur.left:
                findSum(cur.left,count)

            if cur.right:
                findSum(cur.right,count)

        findSum(root,0)
        return Sum        
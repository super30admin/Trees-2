#Trees-2:
#Problem2 : https://leetcode.com/problems/sum-root-to-leaf-numbers/
#All test cases passed on Leetcode
#Time complexity: O(N) since one has to visit each node.
#Space complexity: O(H) to keep the recursion stack, where H is a tree height.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if root==None:
            return 0
        return self.helper(root,0)
    def helper(self,root,currSum):
        if root==None:
            return 0
        if root.left==None and root.right==None:
            return currSum*10+root.val
        left=self.helper(root.left,currSum*10+root.val)
        right=self.helper(root.right,currSum*10+root.val)
        return left+right
            
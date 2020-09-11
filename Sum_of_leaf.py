// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach: using preorder and recursion


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        
        
        def sumOfLeaf(root, curSum = 0):
            if root == None :
                return 0

            if root.left == None and root.right == None:
                return curSum * 10 + root.val

            left = sumOfLeaf(root.left, curSum * 10 + root.val)
            right = sumOfLeaf(root.right, curSum * 10 + root.val)

            return left + right
        return sumOfLeaf(root, 0)

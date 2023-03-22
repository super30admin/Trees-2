# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity : O(n)
# Space Complexity : O(h) where h is height of tree
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach
# take global variable result which need not be stored in recursive stack as
# its value need not be traced back.call sumN on root node and multiply prevsum by 10 and add
# current root.val to ge number till then.if its root node, add the currsum to global result
# recursive call to left and right subtrees
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        global result
        result = 0
        def sumN(root,sumtillthen):
            global result
            if not root:
                return 0
            sumtillthen = sumtillthen * 10 + root.val
            if not root.left and not root.right:
                result += sumtillthen
                return
            sumN(root.left,sumtillthen)
            sumN(root.right,sumtillthen)
        sumN(root, 0)
        return result
    

        
# 129. Sum Root to Leaf Numbers

# code: Approach: keep multipling by 10 when we see a child and then add the val of the child node.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if not root:
            return 0
        
        stk = [(root, root.val)]
        res = 0
        
        while stk:
            curr, sum = stk.pop()
            if curr.left:
                stk.append((curr.left, sum*10 + curr.left.val))
            if curr.right:
                stk.append((curr.right, sum*10+ curr.right.val))
            
            if not curr.left and not curr.right:
                res+=sum
        
        return res

# Time complexity: O(H)  Height of the tree.
# Space complexity: O(H)
# Accepted on Leetcode: Yes.
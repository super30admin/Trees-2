""""// Time Complexity : O(n)
// Space Complexity : O(h), h-height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# Iterative-
class Solution:

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        result = 0
        st = []
        currNum = 0

        while root != None or st:
            while root:
                currNum = currNum * 10 + root.val
                st.append((root, currNum))
                root = root.left
            r = st.pop()
            root = r[0]
            currNum = r[1]
            if not root.left and not root.right:
                result += currNum
            root = root.right
        return result

# Recursive Solution-
# class Solution:
#     def __init__(self):
#         self.result=0

#     def sumNumbers(self, root: Optional[TreeNode]) -> int:
#         self.helper(root, 0)
#         return self.result

#     def helper(self, root, currNum):
#         #base
#         if not root:
#             return

#         self.helper(root.left, currNum*10 + root.val)
#         if not root.left and not root.right:
#             self.result+=currNum*10 + root.val

#         self.helper(root.right, currNum*10 + root.val)

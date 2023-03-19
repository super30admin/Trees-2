# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        st = []
        numStack = []
        num = 0
        s = 0

        while root or st:
            while root:
                st.append(root)
                num = num * 10 + root.val
                numStack.append(num)
                root = root.left

            root = st.pop()
            num = numStack.pop()
            if root.right is None and root.left is None:
                s += num

            root = root.right
        return s

# TC =O(n).
# Space complexity : O(n). Height of the tree
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        sumv = 0
        st = [] # stores Treenodes
        cursum = [] # stores sumv at leaf
        curnum = 0
        while root != None or st:
            while root != None:
                st.append(root)
                curnum = curnum*10 + root.val
                cursum.append(curnum)
                root = root.left
            root = st.pop()
            curnum = cursum.pop()
            if root.left is None and root.right  is None:
                sumv += curnum
            root = root.right
        return sumv
        
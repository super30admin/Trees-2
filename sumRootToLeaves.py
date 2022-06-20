# Time complexity: O(n)
# Space Complexity: O(h)
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        res = 0
        st = deque()
        currNum = 0
        cNumSt = deque()
        while (root is not None) or st:
            while root is not None:
                currNum = currNum * 10 + root.val
                st.append(root)
                cNumSt.append(currNum)
                root = root.left
                
            root = st.pop()
            currNum = cNumSt.pop()
            
            if (root.left is None) and (root.right is None):
                res += currNum
            root = root.right
            
        return res

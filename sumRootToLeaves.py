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
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = 0
    
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root, 0)
        return self.result
    
    def helper(self, root, currNum):
        if root is None:
            return
        #logic
        self.helper(root.left, currNum * 10 + root.val)
        if root.left is None and root.right is None:
            self.result += currNum * 10 + root.val 
        self.helper(root.right, currNum * 10 + root.val)
        
        

'''

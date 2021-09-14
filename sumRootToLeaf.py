# Time Complexity : O(n)
# Space Complexity : O(h) (h = logn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        sum_rToLeaf = 0
        st = [(root,sum_rToLeaf)]
        while st:
            root,curr_num = st.pop()
            if root is not None:
                curr_num = curr_num*10 +root.val
                if root.left == None and root.right == None:
                    sum_rToLeaf +=curr_num
                else:
                    st.append((root.left,curr_num))
                    st.append((root.right,curr_num))
        return sum_rToLeaf
                

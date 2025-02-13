# Time Complexity : O(n), n-> nodes in tree
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        res = []
        cur_path = []
        def backtrack(root):
            if not root:
                return 
            
            if not root.left and not root.right:
                cur_path.append(root.val)
                num_str = ""
                ##process sum
                for num in cur_path:
                    num_str += str(num)
                res.append(int(num_str))
                cur_path.pop()
                return
            
            #action
            cur_path.append(root.val)
            #recursion
            backtrack(root.left)
            backtrack(root.right)
            #backtrack
            cur_path.pop()
        
        backtrack(root)
        return sum(res)
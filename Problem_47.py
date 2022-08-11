# Time complexity: O(n)
# Space Complexity: O(H)   H is the height of the BST
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.ans = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        def helper(root,currNum):
            if not root:
                return
            currNum = currNum * 10 + root.val # This line should be done before left and right recursive calls becasue the current number must be updated to the current root before going to its children
            
            if not root.right and not root.left: # This part can be done before, in between or after left & right recurseive calls
                # Leaf Node
                self.ans += currNum
            
            helper(root.left,currNum)
            
            helper(root.right,currNum)
            
        
        helper(root,0)
        return self.ans
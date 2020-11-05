"""
time complexity O(N)
-Calculate the currentsum at each node and send it locally in Recursive stack so that when we pop out we get the currsum at that point

- Calculate result globally as it will not affect oure much needed output. Putting result as local bvariable will not give desired result as we pop we get different result at different point. 


"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution_sumNumbers:
    def sumNumbers(self, root: TreeNode) -> int:
        global result
        result=0
        if root is None:
            return result
        self.helper(root,0)
        return result
    
    def helper(self,root,currSum):
        global result
        if root is None:
            return
        if root.left is None and root.right is None:
            result+=currSum*10+root.val
            return result
        
        self.helper(root.left,currSum*10+root.val)
        self.helper(root.right,currSum*10+root.val)
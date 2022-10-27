# TC and SC: O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        output=[]
        
        def helper(node,list1):
            if not node.left and not node.right:
                output.append("".join(list1+[str(node.val)]))
            
            if node.left:
                helper(node.left,list1+[str(node.val)])
            if node.right:
                helper(node.right,list1+[str(node.val)])
            
        helper(root,[])
        return sum(int(x) for x in output)
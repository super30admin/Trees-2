# Time Complexity: O(n) where n is the length of the list
# Space Complexity:  O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if postorder == None or len(postorder) == 0:
            return None
        d = dict()
        self.index = len(postorder) - 1
        for i,val in enumerate(inorder):
            d[val] = i
        def helper(postorder,inorder,d,low,high):
            if low > high:
                return None
            root = TreeNode(postorder[self.index])
            self.index -= 1
            break_index = d[root.val]
            root.right =  helper(postorder,inorder,d,break_index+1, high)
            root.left =  helper(postorder,inorder,d,low,break_index-1)
            
            return root
            
            
            
        return helper(postorder,inorder,d,0,len(postorder)-1)

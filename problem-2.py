# Leetcode Execution: YES
# Time Complexity:O(n)
# Space Complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.ar=[]
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        if root.left==None and root.right==None:
            return root.val
        # we check first if the root is alone with no childs we return the root.val
        # we then get all occurenace of root to leaf from left subtree then right subtree
        
        self.helper(root.left,[root.val])
        self.helper(root.right, [root.val])
        return sum(self.ar)
    def helper(self, root,arr):
        if root==None:
            return 
        nums=[]
        
        # finally when we reach the node where there is no children we add all elements from nums to ar
        if root.left==None and root.right==None:
            for x in arr:
                self.ar.append(x*10+root.val)
            return
        
        # we iterate through the array and add the current element at last for all of them
        for x in arr:
            nums.append(x*10+root.val)
        
        
        # recursively moving towards left then right subtrees
        self.helper(root.left,nums)
        self.helper(root.right, nums)
        
            
        
from typing import Optional
# Time Complexity : O(n), Where n is the number of nodes in the binary tree
# Space Complexity : O(h), where h is the height of the binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing Specific

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def actsol(self, root, previousvalue: int)->int:
        #Base case 1
        if(root == None):
            return 0
        #Base case 2
        if(root.left==None and root.right==None):
            #Here we are at leaf node
            return previousvalue*10+root.val
        #Actual Logic
        l=self.actsol(root.left,previousvalue*10+root.val)
        r=self.actsol(root.right,previousvalue*10+root.val)
        return l+r
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        return self.actsol(root,0)
        
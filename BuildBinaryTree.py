# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        inorderHash = {v:i for i,v in enumerate(inorder)}

        def helper(l,r):
            if l > r:
                return None
       
            root = TreeNode(postorder.pop())
            
            mid = inorderHash[root.val]
            root.right = helper(mid+1, r)

            root.left = helper(l,mid-1)
        
            return root
        return helper(0,len(inorder)-1)
    
    
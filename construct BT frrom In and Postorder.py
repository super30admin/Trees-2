# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        
        # hashmap to store index and values of inorder
        mapper = {}
        for i,v in enumerate(inorder):
            mapper[v] = i
            
        def rec(low, high):
            
            if low > high:
                return
            
            val = postorder.pop()
            root = TreeNode(val)
            mid = mapper[root.val]
            
            # build left and right subtrees recursively
            root.right = rec(mid+1, high)
            root.left = rec(low, mid-1)
            return root
        
        return rec(0, len(inorder)-1)
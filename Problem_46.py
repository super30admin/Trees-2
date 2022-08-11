# Time complexity: O(n)
# Space Complexity: O(n) for the hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        hmap = {}
        
        for i in range(len(inorder)):
            hmap[inorder[i]] = i
        
        return self.helper(inorder,0,len(inorder)-1,postorder,hmap)
        
    def helper(self,inorder,instart,inend,postorder,hmap):
        
        if instart > inend:
            return None
        if not postorder:
            return None
        rootVal = postorder.pop()
        root = TreeNode(rootVal)
        
        root_idx = hmap[root.val]
        
        root.right = self.helper(inorder,root_idx+1,inend,postorder,hmap) # Right sub tree should be built first as we are building from post order and popping it
        root.left = self.helper(inorder,instart,root_idx-1,postorder,hmap)
        
        return root
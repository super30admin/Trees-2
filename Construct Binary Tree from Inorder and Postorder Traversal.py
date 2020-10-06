# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    def buildTree(self, inorder, postorder):
        self.post_index = len(postorder)-1
        self.postorder = postorder
        self.hmap = {}
        
        for i in range(len(inorder)):
            self.hmap[inorder[i]] = i
        print(self.hmap)
        
        return self.helper(0,len(inorder)-1)
    
    def helper(self,left,right):
        if left>right:
            return None
        print(self.post_index)
        root_val = self.postorder[self.post_index]
        
        root = TreeNode(root_val)
        self.post_index -= 1
        root.right = self.helper(self.hmap[root_val]+1,right)
        root.left = self.helper(left,self.hmap[root_val]-1)
        
        return root
    
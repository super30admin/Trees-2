# Time Complexity : O(n) [n = number of nodes in a Tree]
# 
# Space Complexity : O(n) [height of tree -> worst case skewed tree]
# 
# Did this code successfully run on Leetcode : Yes
# 
# Any problem you faced while coding this : No
#
# Problem approach
# 1. Recurse over the postorder list in reverse order
# 2. Make the last element as root and segregate the left and right subtree
# 3. Make recursive call for left and right subtree
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if len(postorder) == 0  or len(inorder) == 0:
            return None
        
        root = TreeNode(postorder[len(postorder)-1])
        index = len(postorder)-1
        for i, val in enumerate(inorder):
            if val == root.val:
                index = i
                break
                
        post_left = postorder[:index]
        post_right = postorder[index:len(postorder)-1]
        in_left = inorder[:index]
        in_right = inorder[index+1:]
        root.left = self.buildTree( in_left, post_left)
        root.right = self.buildTree(in_right, post_right)
        return root
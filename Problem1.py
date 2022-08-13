# Hashing solution
# Time complexity : O(n^2)
# Space complexity : O(O^2)
# Leetcode : Solved and submitted

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        # empty hashmap
        nodes = {}
        # check for null or an empty list
        if postorder is None or len(postorder) == 0:
            return None
        # building hasmap with the element and its indices
        for i in range(len(inorder)):
            nodes[inorder[i]] = i
        idx = -1
        # root element is the last element of the postorder as the list is left-right-root
        root = TreeNode(postorder[len(postorder) - 1])
        if root.val in nodes:
            idx = nodes[root.val]
        
        # partition the arrays into left and right subtrees
        in_left = inorder[0:idx]
        in_right = inorder[idx+1:]
        post_left = postorder[0:len(in_left)]
        post_right = postorder[len(post_left):len(postorder)-1]
        
        # recursively call the same function for left and right subtree and return root
        root.left = self.buildTree(in_left, post_left)
        root.right = self.buildTree(in_right, post_right)
        
        return root

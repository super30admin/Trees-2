"""
Trees-2
Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

Time Complexity : O(n) which is storing hashmap or in worst case recursive stack space of h that has n elements.
Space Complexity : O(n) which is hashmap space.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Trick is to understand that post order has the roots starting from end of the list. so we have to keep track of index from
len(postorder)-1. Where as it's next index has right sub tree and then left sub tree irrespective of inorder indicies being
the same. so this is the key difference between constructing from preorder,inorder and inorder,postorder.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not inorder or len(inorder) == 0 or not postorder or len(postorder) == 0:
            return None

        hash_map = {}
        for i in range(len(inorder)):
            hash_map[inorder[i]] = i

        self.idx = len(postorder) - 1
        
        def recurse(postorder, start, end):
            if start > end:
                return None

            root_val = postorder[self.idx]
            self.idx -= 1
            root_node = TreeNode((root_val))
            root_idx = hash_map[root_val]

            root_node.right = recurse(postorder, root_idx + 1, end)
            root_node.left = recurse(postorder, start, root_idx - 1)

            return root_node
 
        return recurse(postorder, 0, len(inorder)-1)        
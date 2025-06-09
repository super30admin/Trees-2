# Time Complexity: O(N), N is the number of nodes in the tree
# Space Complexity: O(H), where H is the number of recursive function calls in the stack
# O (log N) in best case where the tree is balanced and O(N) in the worst case where the tree is skewed
# Did this code successfully run on Leetcode: Yes


from typing import List, Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        index_map = {}

        for index in range(len(inorder)):
            index_map[inorder[index]] = index
        
        self.post_order_index = len(postorder) - 1

        return self.helper(inorder, postorder, index_map, 0, len(inorder) - 1)
    

    def helper(self, inorder, postorder, index_map, start, end):
        if start > end:
            return None


        root_val = postorder[self.post_order_index]
        self.post_order_index -= 1

        root = TreeNode(root_val)
        root_index = index_map[root_val]

        root.right = self.helper(inorder, postorder, index_map, root_index + 1, end)

        root.left = self.helper(inorder, postorder, index_map, start, root_index - 1)

        return root
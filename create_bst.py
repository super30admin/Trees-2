# Time Complexity :O(n)
# Space Complexity :O(n) because of hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
In this code we are reversing the postorder array and then creating a hashmap like we did previously.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if inorder == None or len(inorder) == 0: return None

        postorder.reverse()
        self.postorder_index = 0
        self.hashmap = {number:inorder.index(number) for number in postorder}

        root = self.builder(0, len(postorder)-1, postorder)

        return root

    def builder(self, left, right, postorder):
        if left>right:return

        root = TreeNode(postorder[self.postorder_index])
        self.postorder_index += 1

        root.right = self.builder(self.hashmap[root.val]+1, right, postorder)

        root.left = self.builder(left, self.hashmap[root.val]-1, postorder)

        return root
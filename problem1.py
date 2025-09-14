# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
Space Complexity: O(N) -> Space Occupied by the hashmap
Time Complexity: O(N) -> Time taken to visit the N nodes
"""


class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        idx = len(postorder)-1
        # create an inorder hashmap 
        mp = {}
        for i, v in enumerate(inorder): 
            mp[v] = i

        def build(start, end): 
            nonlocal idx
            # Base condition
            if start > end: 
                return None
            root = TreeNode(postorder[idx])
            idx-=1
            rootval = root.val

            root.right = build(mp[rootval]+1, end)
            root.left = build(start, mp[rootval]-1)


            return root

        return build(0, len(inorder)-1)





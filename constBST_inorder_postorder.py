
"""
TC: O(n) iterating through n elements in array
SP: O(n) to create hashmap, worst case call stack space will be O(n)

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        indices = {k: i for i, k in enumerate(inorder)}
        self.post_idx = -1
        def helper(l, r):
            if l>r:
                return None
            rootVal = postorder[self.post_idx]
            rootIdx = indices[rootVal]
            root = TreeNode(rootVal)
            self.post_idx-=1
            root.right = helper(rootIdx+1, r)
            root.left = helper(l, rootIdx-1)
            return root
        return helper(0, len(inorder)-1)
            
        
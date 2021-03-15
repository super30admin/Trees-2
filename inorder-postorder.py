'''
Time Complexity: O(n)
Space Complexity: O(n)
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        def construct(ins, posts):
            if not ins and not posts:
                return None
            root = posts[-1]
            ri = ins.index(root)
            return TreeNode(root, left=construct(ins[:ri], posts[:ri]), \
                            right=construct(ins[ri + 1:], posts[ri:-1]))

        return construct(inorder, postorder)
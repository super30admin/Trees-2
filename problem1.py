# Time Complexity : O(n), n-> nodes in tree
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        map = {}
        for i in range(len(inorder)):
            map[inorder[i]] = i
        
        cur_ix = [len(postorder) - 1]
        def recurse(left, right):
            if left > right:
                return None
            
            root_val = postorder[cur_ix[0]]
            root_ix = map[root_val]
            node = TreeNode(root_val)
            cur_ix[0] -= 1

            node.right = recurse(root_ix+1, right)
            node.left = recurse(left, root_ix-1)

            return node
        
        return recurse(0, len(postorder) - 1)
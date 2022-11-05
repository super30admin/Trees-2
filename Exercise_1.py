# Time Complexity: O(n)
# Space Complexity: O(h) -> h is the height of the tree
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        hashmap = dict()
        for i, val in enumerate(inorder):
            hashmap[val] = i
            
        def helper(in_start, in_end, p_start, p_end):
            if in_start<=in_end:
                root = TreeNode(postorder[p_end])
                idx = hashmap[root.val]
                delta = idx - in_start
                root.left = helper(in_start, idx-1, p_start, p_start+delta-1)
                root.right = helper(idx+1, in_end, p_start+delta, p_end-1)
                return root
            else:
                return None
        
        return helper(0, len(inorder)-1, 0, len(postorder)-1)        
"""
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
// Your code here along with comments explaining your approach
Algorithm explanation
Following from the preorder explanation, we approach this problem in simlar
way with only difference being fetching the root from the last element in postorder
post_left & in_left remain same ie till elements index of root in inorder
post_right - index+1 till one but last(root)
in_right - index+1 till end
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        inorder_dict = dict((v,i) for i,v in enumerate(inorder))
        def helper(inorder,postorder):
            if not inorder:
                return None
            root = TreeNode(postorder[-1])
            index = inorder.index(root.val)
            root.left = helper(inorder[:index],postorder[:index])
            root.right = helper(inorder[index+1:],postorder[index:-1])
            return root
        
        return helper(inorder,postorder)
'''
Problem: Construct Binary Tree from postorder and inorder
Time Complexity: O(n), where n is number of nodes
Space Complexity: O(n) for the hashmap
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        create hashmap on inorder for O(1) of search
        recurse on postorder using start and end index for left and right
        first do right subtree and then left
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        idx = len(inorder)-1
        hashmap ={}
        for i,val in enumerate(inorder):
            hashmap[val]=i

        def helper(postorder, start, end):
            nonlocal idx
            #base
            if start>end:
                return None

            #logic
            rootval = postorder[idx]
            idx-=1
            root = TreeNode(rootval)
            rootidx =  hashmap[rootval]

            root.right = helper(postorder, rootidx+1, end)
            root.left = helper(postorder, start, rootidx-1)
            
            return root

        return helper(postorder, 0, len(inorder)-1)
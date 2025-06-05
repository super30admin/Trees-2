"""
problem: Construct Binary Tree from Inorder and Postorder Traversal

Approach: Similar to Construct Binary Tree from Inorder and preorder Traversal only difference being
we can treat the post order as a reversed preorder so we can start from the end to get the next
root node to create and the children information can be deduced from the inorder list which tells us
when to stop and backtrack.
t.c. => O(n) where n = number of nodes
s.c. => O(h) where h is the max height of the tree where h = n if tree is not balanced.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        n = len(inorder)
        self.postPointer = n - 1
        inorderIndex = collections.defaultdict(int)
        
        
        for i in range(n):
            inorderIndex[inorder[i]] = i
        
        def helper(l, r):
            if l > r:
                return 
            
            rootval = postorder[self.postPointer]
            root = TreeNode(rootval)
            self.postPointer -= 1
            idx = inorderIndex[rootval]
            root.right = helper(idx + 1, r)
            root.left = helper(l, idx - 1)
            

            return root
        return helper(0, n - 1)
        
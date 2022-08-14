# Time complexity : O(n)
# Space complexity : O(n)
# Leetcode : Solved and submitted

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        # making a hashmap and filling it with the indexes of the elements in the inorder tree
        self.nodes = {}
        for i in range(len(inorder)):
            self.nodes[inorder[i]] = i
        # calling the helper function and setting the inorder boundaries which is 0 till the end of the list
        return self.helper(inorder, 0, len(inorder)-1, postorder)
    
    def helper(self, inorder, start, end, postorder):
        # checking the base cases which is the boundary conditions and postorder list if it is None or empty
        if start > end:
            return None
        if postorder is None or len(postorder) == 0:
            return None
        #idx = -1
        
        # fetch the root as the last element from postorder, find it's index from the hashmap
        root = TreeNode(postorder.pop())
        if root.val in self.nodes:
            idx = self.nodes[root.val]
        
        # recursively call the helper function in the left and right subtree with the reduced length of inorder and postorder lists
        # then finally return the root
        root.right = self.helper(inorder, idx + 1, end, postorder)
        root.left = self.helper(inorder, start, idx - 1, postorder)
        
        return root

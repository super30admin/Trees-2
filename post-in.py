# O(n) time and space
# same as pre order in order but reverse pointer and right and left calls
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.idx = len(postorder)-1
        # Create an empty dictionary
        inorder_map = {}

        # Use a standard loop with enumerate to fill it: { val: i }
        for i, val in enumerate(inorder):
            inorder_map[val] = i
        return self.helper(postorder, 0, len(inorder) - 1, inorder_map)

    def helper(self, postorder, start, end, inorder_map):
        if start > end:
            return None 
        # move preorder index by 1 each time
        rootVal = postorder[self.idx]
        self.idx-=1
        root = TreeNode(rootVal)
        rootIdx = inorder_map[rootVal]
        root.right = self.helper(postorder, rootIdx+1,end,inorder_map)
        root.left = self.helper(postorder,start,rootIdx-1,inorder_map)

        return root 
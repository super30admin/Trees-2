# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    #O(N)
#O(N)
#last value of postorder is root
#get that values's index from inorder and traverse from (index+1...end) for right side and (srt...index-1) for left side
    def buildTree(self, inorder, postorder):
        map_inorder = {}
        for i, val in enumerate(inorder): map_inorder[val] = i
        def recur(low, high):
            if low > high: return None
            #root is present aat last position in postorder
            root_val=postorder.pop()
            root = TreeNode(root_val)
            root_index= map_inorder[root_val]
            #traversing postorder from end, right comes next
            root.right = recur(root_index+1, high)
            root.left = recur(low, root_index-1)
            return root
        return recur(0, len(inorder)-1)
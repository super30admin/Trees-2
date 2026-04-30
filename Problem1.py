# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity --> O(n)
# Space Complexity --> O(n)
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        
        self.hmap = {}
        for i in range(len(inorder)):
            self.hmap[inorder[i]] = i
        n = len(inorder)
        self.idx = n-1
        return self.helper(postorder, 0, n-1)
    
    def helper(self, postorder, st, end):
        # base
        if st>end:
            return None

        # logic
        print(self.idx)
        root_val = postorder[self.idx]
        root_idx = self.hmap[root_val]
        self.idx -= 1

        root = TreeNode(root_val)
        root.right = self.helper(postorder, root_idx+1, end)
        root.left = self.helper(postorder, st, root_idx-1)

        return root


'''

# Time Complexity --> O(n^2)
# Space Complexity --> O(n^2)
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not postorder:
            return None
        
        root_val = postorder[-1]
        hmap = {}
        for i in range(len(inorder)):
            hmap[inorder[i]] = i
        root_idx = hmap[root_val]

        inleft = inorder[:root_idx]
        inright = inorder[root_idx+1:]
        postleft = postorder[:len(inleft)]
        postright = postorder[len(inleft):-1]

        root = TreeNode(root_val)
        root.left = self.buildTree(inleft, postleft)
        root.right = self.buildTree(inright, postright)

        return root
'''

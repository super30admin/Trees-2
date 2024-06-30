#Time Complexity : O(n)
#Space Complexity : O(n) - hashmap
#Any problem you faced while coding this : -

#This approach constructs a binary tree from given inorder and postorder traversal lists. It uses a recursive helper function, with a mapping of inorder values to indices for quick lookup. Starting from the last element in postorder (the root), it builds the tree by recursively creating right and left subtrees. It constructs the right subtree first using elements after the root's index in the inorder list, then constructs the left subtree using elements before the root's index.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    idx = 0
    mapping = defaultdict()

    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.idx = len(postorder) - 1
        for i in range(len(inorder)):
            self.mapping[inorder[i]] = i

        return self.helper(postorder, 0, len(inorder) - 1)

    def helper(self, postorder, st, ed):
        #base condition
        if st > ed:
            return None

        #get root
        rootVal = postorder[self.idx]
        self.idx -= 1
        root = TreeNode(rootVal)
        rootIdx = self.mapping[rootVal]
        root.right = self.helper(postorder, rootIdx + 1, ed)
        root.left = self.helper(postorder, st, rootIdx - 1)

        return root

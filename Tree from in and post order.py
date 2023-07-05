# Time Complexity : O(n)
# Space Complexity : O(H), height of tree

# The code ran on LeetCode

# Maintain a hash map of the indices of inorder array. The root element is at the right end of the postorder array. Traverse from right to left on the postorder array and add elements at the right position using the inorder array. Right side of a root element in the inorder array corresponds to the right sub tree from that root element and left side corresponds to left sub tree from that root node.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:

        # Store indices of inorder in a hash map
        self.in_map = {}
        for i in range(len(inorder)):
            self.in_map[inorder[i]] = i

        start = 0; end = len(postorder) - 1
        self.idx = len(postorder) - 1
        
        def construct(postorder, start, end):

            if start > end:
                return None
            
            rootVal = postorder[self.idx]
            rootIdx = self.in_map[rootVal]
            self.idx -= 1

            root = TreeNode(rootVal)

            root.right = construct(postorder, rootIdx + 1, end)

            root.left = construct(postorder, start, rootIdx - 1)

            return root

        return construct(postorder, start, end)


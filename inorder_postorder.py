# This solution reconstructs a binary tree from its inorder and postorder traversal arrays.
# It uses a hashmap to store the index of each value in the inorder array for O(1) lookups.
# The helper function recursively builds the tree from the bottom-up using postorder traversal.

# Time Complexity: O(n), where n is the number of nodes. Each node is processed once.
# Space Complexity: O(n), for the hashmap and the recursion stack in the worst case.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        hashMap = {}
        for index, num in enumerate(inorder):
            hashMap[num] = index
        
        p = len(postorder) - 1
        def helper(left, right):
            nonlocal p
            if left > right:
                return None
            
            num = postorder[p]
            node = TreeNode(num)
            p -= 1

            index = hashMap[num]

            node.right = helper(index + 1, right)
            node.left = helper(left, index - 1)

            return node

        return helper(0, len(inorder) - 1)

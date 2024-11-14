# The code defines a buildTree method to construct a binary tree from inorder and postorder traversal lists.
# The approach uses a recursive depth-first search (dfs) to build the tree by maintaining the correct order of nodes based on traversal properties.

# Initial Setup:
#   - 'postIdx' is initialized to the last index of postorder, representing the current root node in the postorder traversal.
#   - 'inIdx' is initialized to the last index of inorder, which helps in managing subtree boundaries.

# Recursive Depth-First Search (dfs):
#   - The dfs function takes 'limit' as an argument, which helps in managing the current subtree boundary.
#   - Base case:
#       - If 'postIdx' is less than 0, return None as there are no more nodes to process.
#       - If inorder[inIdx] equals 'limit', it indicates we've reached the boundary of the current subtree.
#           - Decrement inIdx and return None to prevent adding further nodes in this subtree.
#   
#   - Create a new TreeNode with the value at postorder[postIdx] to represent the root of the current subtree.
#       - Decrement postIdx to move to the next node in postorder for subsequent recursive calls.
#       - Recursively build the right subtree first by calling dfs with the current root's value as the new limit.
#       - Recursively build the left subtree with the original limit, as postorder traversal processes the right subtree before the left.
#   - Return the constructed 'root' node after both left and right subtrees have been built.

# Main Execution:
#   - The buildTree method starts the tree construction by calling dfs with an infinite limit, allowing all values initially.
#   - It returns the root of the fully constructed tree.

# TC: O(n) - Each node is processed once, so the time complexity is linear in the number of nodes.
# SC: O(n) - The space complexity is linear due to the recursion stack, which could go up to n levels deep in the worst case.


from typing import List, Optional


class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        postIdx = len(postorder) - 1
        inIdx = len(inorder) - 1

        def dfs(limit):
            nonlocal postIdx, inIdx
            if postIdx < 0:
                return None
            if inorder[inIdx] == limit:
                inIdx -= 1
                return None

            root = TreeNode(postorder[postIdx])
            postIdx -= 1
            root.right = dfs(root.val)
            root.left = dfs(limit)
            return root

        return dfs(float('inf'))

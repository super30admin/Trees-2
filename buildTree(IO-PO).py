from typing import List, Optional
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# Approach: Naive Recursion with List Slicing
# Find root from postorder[-1], locate in inorder, recursively split
# TC = O(n^2) - because slicing and linear search in each recursion
# SC = O(n)   - recursion depth + list slices
class Solution:
    def buildTree1(
        self, inorder: List[int], postorder: List[int]
    ) -> Optional[TreeNode]:
        if not postorder:
            return None

        rootVal = postorder[-1]
        root = TreeNode(rootVal)

        # Find root index in inorder (linear search)
        rootidx = -1
        for index, val in enumerate(inorder):
            if val == rootVal:
                rootidx = index
                break

        inleft = inorder[:rootidx]
        postleft = postorder[:rootidx]

        inright = inorder[rootidx + 1 :]
        postright = postorder[rootidx : len(postorder) - 1]

        root.left = self.buildTree1(inleft, postleft)
        root.right = self.buildTree1(inright, postright)

        return root

    # Approach: Optimized Recursion with HashMap
    # Use a map to locate root index in inorder in O(1)
    # Avoid list slicing by passing indices
    # TC = O(n), SC = O(n)
    def buildTree2(
        self, inorder: List[int], postorder: List[int]
    ) -> Optional[TreeNode]:
        map_inorder = {val: idx for idx, val in enumerate(inorder)}
        return self.helper(
            inorder, 0, len(inorder) - 1, postorder, 0, len(postorder) - 1, map_inorder
        )

    def helper(
        self,
        inorder: List[int],
        instart: int,
        inend: int,
        postorder: List[int],
        poststart: int,
        postend: int,
        map_inorder: dict,
    ) -> Optional[TreeNode]:

        if instart > inend or poststart > postend:
            return None

        rootVal = postorder[postend]
        root = TreeNode(rootVal)
        rootidx = map_inorder[rootVal]

        # Number of nodes in left subtree
        left_tree_size = rootidx - instart

        root.left = self.helper(
            inorder,
            instart,
            rootidx - 1,
            postorder,
            poststart,
            poststart + left_tree_size - 1,
            map_inorder,
        )

        root.right = self.helper(
            inorder,
            rootidx + 1,
            inend,
            postorder,
            poststart + left_tree_size,
            postend - 1,
            map_inorder,
        )

        return root


# Print level order to verify structure
def print_level_order(root: Optional[TreeNode]):
    if not root:
        print("[]")
        return

    queue = deque([root])
    result = []

    while queue:
        node = queue.popleft()
        if node:
            result.append(node.val)
            queue.append(node.left)
            queue.append(node.right)
        else:
            result.append(None)

    # Trim trailing None values
    while result and result[-1] is None:
        result.pop()

    print(result)


# Sample Test
if __name__ == "__main__":
    inorder = [9, 3, 15, 20, 7]
    postorder = [9, 15, 7, 20, 3]

    print("Naive:")
    tree1 = Solution().buildTree1(inorder, postorder)
    print_level_order(tree1)

    print("\nOptimized:")
    tree2 = Solution().buildTree2(inorder, postorder)
    print_level_order(tree2)

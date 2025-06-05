"""
Move from root to leaf using DFS, building the number as curr_sum * 10 + node.val.
When leaf is reached, return the formed number.
Sum all numbers from every root-to-leaf path.
"""
"""
Time Complexity: O(n) – visit each node once
Space Complexity: O(h) – recursion stack (h = tree height)
"""


from typing import Optional
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class sumRootToLeaf:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def dfs(node, current_sum):
            if not node:
                return 0
            current_sum = current_sum * 10 + node.val
            if not node.left and not node.right:
                return current_sum
            return dfs(node.left, current_sum) + dfs(node.right, current_sum)
        
        return dfs(root, 0)

def build_tree(levels):
    if not levels:
        return None
    root = TreeNode(levels[0])
    queue = deque([root])
    i = 1
    while queue and i < len(levels):
        node = queue.popleft()
        if levels[i] is not None:
            node.left = TreeNode(levels[i])
            queue.append(node.left)
        i += 1
        if i < len(levels) and levels[i] is not None:
            node.right = TreeNode(levels[i])
            queue.append(node.right)
        i += 1
    return root

if __name__ == "__main__":
    tree_values = [1, 2, 3]
    root = build_tree(tree_values)

    obj = sumRootToLeaf()
    print(obj.sumNumbers(root))

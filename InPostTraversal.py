"""
Last element in postorder will be root and reduce pointer.
Use hashmap to split inorder into left/right subtrees.
Recurse right then left (postorder is L , R , Root, so in reverse).
"""
"""
Time Complexity: O(n) — each node visited once
Space Complexity: O(n) — recursion + hashmap
"""
from collections import deque
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class InPostTraversal:
    def buildTree(self, inorder, postorder):
        inorder_index = {val: idx for idx, val in enumerate(inorder)}
        self.post_idx = len(postorder) - 1

        def helper(left, right):
            if left > right:
                return None

            root_val = postorder[self.post_idx]
            self.post_idx -= 1
            root = TreeNode(root_val)

            mid = inorder_index[root_val]
            root.right = helper(mid + 1, right)
            root.left = helper(left, mid - 1)
            return root

        return helper(0, len(inorder) - 1)

def tree_to_level_order_list(root):
    if not root:
        return []
    result = []
    queue = deque([root])
    while queue:
        node = queue.popleft()
        if node:
            result.append(node.val)
            queue.append(node.left)
            queue.append(node.right)
        else:
            result.append(None)
    

    while result and result[-1] is None:
        result.pop()
    return result


if __name__ == "__main__":
    inorder = [9, 3, 15, 20, 7]
    postorder = [9, 15, 7, 20, 3]

    obj = InPostTraversal()
    root = obj.buildTree(inorder, postorder)
    print(tree_to_level_order_list(root))
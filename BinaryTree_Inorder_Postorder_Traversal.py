# Time Complexity :
- O(n), where n is the number of nodes in the tree each node is visited once

# Space Complexity :
- O(n), for the hashmap and recursion stack in the worst case of a skewed tree

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        inorder_index_map = {val: idx for idx, val in enumerate(inorder)}
        postorder_index = len(postorder) - 1

        def build(left, right):
            nonlocal postorder_index
            if left > right:
                return None

            root_val = postorder[postorder_index]
            root = TreeNode(root_val)
            postorder_index -= 1

            index = inorder_index_map[root_val]

            root.right = build(index + 1, right)
            root.left = build(left, index - 1)

            return root

        return build(0, len(inorder) - 1)

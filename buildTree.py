
class Solution:
    def buildTree(self, inorder, postorder):
        val_to_index = {val: idx for idx, val in enumerate(inorder)}

        self.post_idx = len(postorder) - 1

        def build(in_left, in_right):
            if in_left > in_right:
                return None

            root_val = postorder[self.post_idx]
            self.post_idx -= 1

            root = TreeNode(root_val)

            idx = val_to_index[root_val]

            root.right = build(idx + 1, in_right)
            root.left = build(in_left, idx - 1)

            return root

        return build(0, len(inorder) - 1)

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        idx = {val: i for i, val in enumerate(inorder)}
        self.post_idx = len(postorder) - 1

        def helper(left, right):
            if left > right:
                return None

            root_val = postorder[self.post_idx]
            self.post_idx -= 1
            root = TreeNode(root_val)

            mid = idx[root_val]

            # build right subtree first
            root.right = helper(mid + 1, right)
            root.left = helper(left, mid - 1)

            return root
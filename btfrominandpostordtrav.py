class Solution:
    def buildTree(self, inorder, postorder):

        inorder_map = {}

        for i, val in enumerate(inorder):
            inorder_map[val] = i

        self.idx = len(postorder) - 1

        def dfs(left, right):
            if left > right:
                return None

            # Root is at the end of postorder
            root_val = postorder[self.idx]
            self.idx -= 1

            root = TreeNode(root_val)

            mid = inorder_map[root_val]

            # IMPORTANT:
            # Build right subtree first
            root.right = dfs(mid + 1, right)

            root.left = dfs(left, mid - 1)

            return root

        return dfs(0, len(inorder) - 1)

    # TC - O(n)
    # SC - O(n) because of inorder Hashmap and recursion stack O(h)
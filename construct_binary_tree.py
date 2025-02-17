class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
    
        inorder_index_map = {value: idx for idx, value in enumerate(inorder)}

        def build(pre_start, in_start, in_end):
            if pre_start >= len(preorder) or in_start > in_end:
                return None

            root_val = preorder[pre_start]
            root = TreeNode(root_val)

            in_index = inorder_index_map[root_val]
            root.left = build(pre_start + 1, in_start, in_index - 1)

            root.right = build(pre_start + (in_index - in_start + 1), in_index + 1, in_end)

            return root

        return build(0, 0, len(inorder) - 1)
# Time complexity - O(n)
# Space complexity - O(n)

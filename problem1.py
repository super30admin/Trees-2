
# Time complexity : O(N)
# Space complexity : O(N)
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        def helper(in_left: int, in_right: int) -> TreeNode:

            if in_left > in_right:
                return None


            val = postorder.pop()
            root = TreeNode(val)


            index = idx_map[val]


            root.right = helper(index + 1, in_right)

            root.left = helper(in_left, index - 1)
            return root


        idx_map = {val: idx for idx, val in enumerate(inorder)}
        return helper(0, len(inorder) - 1)
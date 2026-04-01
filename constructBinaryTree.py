# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use recursion with hashmap.
# The last element in postorder is the root of the tree.
# Use a hashmap to find the index of the root in inorder in O(1).
# Split inorder into left and right subtrees using that index.
# Since we traverse postorder from the end, build the right subtree first,
# then the left subtree.
# Recursively construct the tree until the range becomes invalid.

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        idx_map = {}
        for i in range(len(inorder)):
            idx_map[inorder[i]] = i

        self.post_idx = len(postorder) - 1

        def helper(left, right):
            if left > right:
                return None

            root_val = postorder[self.post_idx]
            self.post_idx -= 1

            root = TreeNode(root_val)
            mid = idx_map[root_val]

            root.right = helper(mid + 1, right)
            root.left = helper(left, mid - 1)

            return root

        return helper(0, len(inorder) - 1)
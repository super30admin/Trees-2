"""
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
Approach 1:
Same approach as the previous problem. Just pick the root from the end of the preorder list and find it in the in order
list.

TC: O(n^2)
SC: O(n^2)
"""
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if not inorder:
            return None

        root_val = postorder[-1]
        root = TreeNode(root_val)
        root_index = None
        for i, node_val in enumerate(inorder):
            if node_val == root_val:
                root_index = i
                break
        # print(root_index)
        in_left = inorder[:root_index]
        in_right = inorder[root_index + 1:]
        post_left = postorder[:len(in_left)]
        post_right = postorder[len(in_left):-1]

        root.left = self.buildTree(in_left, post_left)
        root.right = self.buildTree(in_right, post_right)
        return root


"""
# Approach 2: use hashmap and pointers
TC: O(n)
SC: O(n)
"""
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if not inorder:
            return None

        hash_map = {}
        for i, node_val in enumerate(inorder):
            hash_map[node_val] = i

        return self.helper(inorder, postorder, 0, len(inorder) - 1, 0, len(postorder) - 1, hash_map)

    def helper(self, inorder, postorder, in_start, in_end, post_start, post_end, hash_map):
        if in_start > in_end or post_start > post_end:
            return None
        root_val = postorder[post_end]
        root = TreeNode(root_val)
        root_index = hash_map[root_val]
        in_left_len = root_index - in_start
        root.left = self.helper(inorder, postorder, in_start, root_index - 1, post_start, post_start + in_left_len - 1,
                                hash_map)
        root.right = self.helper(inorder, postorder, root_index + 1, in_end, post_start + in_left_len, post_end - 1,
                                 hash_map)
        return root
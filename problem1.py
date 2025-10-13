# Time Complexity : O(N) 
# (Each node is visited once, and dictionary lookups are O(1))
# 
# Space Complexity : O(N)
# (O(N) for recursion stack + O(N) for hashmap)
# 
# Did this code successfully run on Leetcode : Yes
# 
# Any problem you faced while coding this :
# Initially confusing part was remembering to build the right subtree first 
# because we are consuming postorder from the end (postorder = [Left, Right, Root])

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        # Index pointer starting from the last element of postorder
        self.idx = len(postorder) - 1

        # Create a hashmap for quick lookup of inorder indices
        inorder_map = {val: i for i, val in enumerate(inorder)}

        # Start helper recursion between full inorder range
        return self.helper(postorder, 0, len(inorder) - 1, inorder_map)

    def helper(self, postorder, start, end, inorder_map):
        # Base case: if start index passes end index, no subtree exists
        if start > end:
            return None

        # The current root is the last remaining element in postorder
        root_val = postorder[self.idx]
        self.idx -= 1  # Move to the next element (previous node in postorder)

        # Create a new tree node
        root = TreeNode(root_val)

        # Find this root's position in inorder (splits left/right subtrees)
        root_idx = inorder_map[root_val]

        # Important:
        # Since postorder is Left → Right → Root, and we are traversing from the end,
        # we must build the RIGHT subtree before the LEFT subtree.
        root.right = self.helper(postorder, root_idx + 1, end, inorder_map)
        root.left = self.helper(postorder, start, root_idx - 1, inorder_map)

        # Return the constructed subtree
        return root

'''
    Time Complexity:
        O(n) (where h = number of nodes)

    Space Complexity:
        O(n) (where n = number of nodes)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Store the inorder sequence in a HashMap of val: idx.
        Intially start building the tree for the entire inorder array.
        You need a global variable to manage the index of the root node.
        Use the inorder hash map to find the index of your root.
        [root_idx+1: End] is your right subtree.
        [Start: root_idx] is your left subtree.
'''
class Solution:
    def __init__(self):
        self.post_order = []
        self.in_order_map = {}
        self.root_idx = 0

    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        self.post_order = postorder

        for idx, node_val in enumerate(inorder):
            self.in_order_map[node_val] = idx

        self.root_idx = len(self.post_order) - 1

        return self.generate_tree(0, len(inorder) - 1)

    def generate_tree(self, start, end):
        if start > end:
            return None

        root_val = self.post_order[self.root_idx]
        root = TreeNode(root_val)

        self.root_idx -= 1

        inorder_idx = self.in_order_map[root_val]
        root.right = self.generate_tree(inorder_idx + 1, end)
        root.left = self.generate_tree(start, inorder_idx - 1)

        return root

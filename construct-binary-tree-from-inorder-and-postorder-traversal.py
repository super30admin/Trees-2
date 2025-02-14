# We use postorder to determine the root (last element) and a hashmap (mapping) to find its index in inorder, 
# allowing us to recursively build the right subtree first (since postorder is [left, right, root]), then the left subtree.
# Time Complexity:O(n) (Each node is processed once, and hashmap lookups take O(1)).
# Space Complexity:O(n) (Hashmap storage and recursion stack in the worst case).
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        mapping = {}
        for i in range(len(postorder)):
            mapping[inorder[i]] = i
        postorder = collections.deque(postorder)

        def build(start, end):
            if start > end:
                return None
            root = TreeNode(postorder.pop())
            mid = mapping[root.val]
            root.right = build(mid + 1, end)
            root.left = build(start, mid - 1)
            
            return root
        return build(0, len(postorder) - 1)
"Time Complexity is O(N)"
"Space Complexity is O(N)"
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        # Create a hashmap for quick lookup of root indices in inorder
        inorder_map = {val: idx for idx, val in enumerate(inorder)}
        
        def helper(in_left, in_right):
            if in_left > in_right:
                return None  # Base case: No elements to construct the tree
            
            # Step 1: Get the root value from the end of postorder
            root_val = postorder.pop()
            root = TreeNode(root_val)
            
            # Step 2: Find the root's index in the inorder array using the hashmap
            root_index = inorder_map[root_val]
            
            # Step 3: Build the right and left subtrees recursively
            # Build the right subtree first, then the left subtree
            root.right = helper(root_index + 1, in_right)
            root.left = helper(in_left, root_index - 1)
            
            return root
        
        return helper(0, len(inorder) - 1)

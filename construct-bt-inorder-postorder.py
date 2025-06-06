''' 

Problem: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

Approach: 
    1. Traverse the postorder traversal and find the root node.
    2. Traverse the inorder traversal and find the left and right subtrees.
    3. Create a new tree node with the root value and the left and right subtrees.
    4. Return the root node.
    
Time Complexity: O(n^2) where n is the number of nodes in the tree and the inorder and postorder traversals have length n.
Space Complexity: O(h) where h is the height of the tree.
'''


# Array Slicing Approach 
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:

        def solve(postorder, inorder):
            if len(postorder) == 0:
                return None
            root = postorder[-1]
            rootIndex = -1

            for i in range(len(inorder)):
                if inorder[i] == root:
                    rootIndex = i
                    break


            left_in = inorder[:rootIndex]
            right_in = inorder[rootIndex + 1 :]

            L = len(left_in)

            left_pre = postorder[:L]
            right_pre = postorder[L:-1]

            root = TreeNode(postorder[-1])
            root.left = solve(left_pre, left_in)
            root.right = solve(right_pre, right_in)

            return root

        return solve(postorder, inorder)

# Using Hashmap Approach and Indexing Approach 
# Time Complexity: O(n) where n is the number of nodes in the tree.
# Space Complexity: O(n)+O(h) where n is the number of nodes in the tree and h is the height of the tree.
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:

        inorder_map = {val: idx for idx, val in enumerate(inorder)}
        post_idx = len(postorder) - 1

        def build(in_left, in_right):
            nonlocal post_idx
            if in_left > in_right:
                return None

            root_val = postorder[post_idx]
            post_idx -= 1
            root = TreeNode(root_val)

            index = inorder_map[root_val]

            root.right = build(index + 1, in_right)
            root.left = build(in_left, index - 1)

            return root

        return build(0, len(inorder) - 1)

# Time Complexity : O(n)
# Space Complexity : O(n)
# Definition for a binary tree node.
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def __init__(self):
        self.map = {}
        self.index = 0

    def treeBuilder(self, postorder, start, end):
        if start > end:
            return None
        rootVal = postorder[self.index]
        self.index -= 1
        root = TreeNode(rootVal)
        rootIndex = self.map[rootVal]
        root.right = self.treeBuilder(postorder, rootIndex + 1, end)
        root.left = self.treeBuilder(postorder, start, rootIndex - 1)
        return root

    def buildTree(self, inorder, postorder):
        if not inorder or not postorder:
            return None
        self.index = len(postorder) - 1
        self.map = {val: idx for idx, val in enumerate(inorder)}
        return self.treeBuilder(postorder, 0, len(postorder) - 1)

# Helper function to print the tree in a readable form
def print_tree(node, level=0, label="."):
    indent = " " * (4 * level)
    if node is None:
        print("{}{}: None".format(indent, label))
        return
    print("{}{}: {}".format(indent, label, node.val))
    print_tree(node.left, level + 1, "L")
    print_tree(node.right, level + 1, "R")

# Examples
solution = Solution()

# Example 1
inorder1 = [9, 3, 15, 20, 7]
postorder1 = [9, 15, 7, 20, 3]
tree1 = solution.buildTree(inorder1, postorder1)
print("Example 1:")
print_tree(tree1)

# Example 2
inorder2 = [2, 1, 3]
postorder2 = [2, 3, 1]
tree2 = solution.buildTree(inorder2, postorder2)
print("\nExample 2:")
print_tree(tree2)

# Example 3
inorder3 = [4, 2, 5, 1, 6, 3]
postorder3 = [4, 5, 2, 6, 3, 1]
tree3 = solution.buildTree(inorder3, postorder3)
print("\nExample 3:")
print_tree(tree3)

